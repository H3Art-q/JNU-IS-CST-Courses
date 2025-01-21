function find_matches_along_epilines(F, img1, img2, matchedPoints1, matchedPoints2)
% Check the type of matchedPoints1 and matchedPoints2
if isa(matchedPoints1, 'cornerPoints')
    points1_h = [matchedPoints1.Location, ones(size(matchedPoints1.Location, 1), 1)];
elseif ismatrix(matchedPoints1)
    points1_h = [matchedPoints1, ones(size(matchedPoints1, 1), 1)];
else
    error('Unsupported data type for matched points.');
end

% Compute the epipolar lines in image 2
epiLines2 = points1_h * F';

% Create a side-by-side image display
figureHandle = figure;
subplot(1, 2, 1);
imshow(img1); title('First Image with matching points');
hold on;
plot(matchedPoints1(:, 1), matchedPoints1(:, 2), 'go', 'MarkerSize', 5, 'LineWidth', 0.5); % Plot matching points in image 1
hold off;

subplot(1, 2, 2);
imshow(img2); title('Second Image with epipolar lines and matching points');
hold on;

for i = 1:size(epiLines2, 1)
    % Get the current epipolar line equation
    lineEq = epiLines2(i, :);
    
    % Calculate the intersection points of the epipolar line with the image borders
    linePoints = lineToBorderPoints(lineEq, size(img2));
    % Plot the epipolar line
    if numel(linePoints) == 4
        line([linePoints(1), linePoints(3)], [linePoints(2), linePoints(4)], 'Color', 'r', 'LineWidth', 0.5);
    else
        disp(['Invalid line points for epipolar line ', num2str(i)]);
    end
    
    % Find the matching point along the epipolar line
    bestMatch = find_best_match_along_epiline(lineEq, img1, img2, matchedPoints1(i, :));
    if ~isempty(bestMatch)
        % Mark the original point in image 1
        subplot(1, 2, 1);
        hold on;
        plot(matchedPoints1(i, 1), matchedPoints1(i, 2), 'bo', 'MarkerSize', 5, 'LineWidth', 0.5);
        
        % Plot the matching point in image 2
        subplot(1, 2, 2);
        plot(bestMatch(1), bestMatch(2), 'bo', 'MarkerSize', 5, 'LineWidth', 0.5);
    end
end
hold off;

% Save the image
outputDir = './temp_results/'; % Directory to save results
if ~exist(outputDir, 'dir')
    mkdir(outputDir); % Create the directory if it does not exist
end

% Save as a PNG file
savePath = fullfile(outputDir, 'matches_along_epilines.png');
exportgraphics(figureHandle, savePath, 'Resolution', 600);

% Close the figure to avoid memory usage
close(figureHandle);

end

function bestMatch = find_best_match_along_epiline(lineEq, img1, img2, point1)
% Define the size of the search window
patchSize = 5; % Image patch size

% Get the image patch around point 1
x1 = round(point1(1));
y1 = round(point1(2));
patch1 = img1(max(1, y1-patchSize):min(size(img1, 1), y1+patchSize), ...
    max(1, x1-patchSize):min(size(img1, 2), x1+patchSize));

% Initialize the best match
bestScore = inf; % The smaller the better
bestMatch = [];

% Traverse points along the epipolar line in image 2 to find the matching point
for x2 = 1:size(img2, 2)
    % Calculate the y2 value
    y2 = -(lineEq(1) * x2 + lineEq(3)) / lineEq(2);
    y2 = round(y2); % Round to the nearest integer
    if y2 < 1 || y2 > size(img2, 1) % Check if the point is within the image boundaries
        continue;
    end
    
    % Get the image patch around point 2
    patch2 = img2(max(1, y2-patchSize):min(size(img2, 1), y2+patchSize), ...
        max(1, x2-patchSize):min(size(img2, 2), x2+patchSize));
    
    % Calculate the similarity (SSD or NCC)
    if size(patch1) == size(patch2) % Ensure the two image patches are the same size
        score = sum((double(patch1(:)) - double(patch2(:))).^2); % SSD
        if score < bestScore
            bestScore = score;
            bestMatch = [x2, y2];
        end
    end
end
end