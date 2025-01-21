function visualize_epipolar_lines(F, matchedPoints1, matchedPoints2, img1, img2, methodName)
% Ensure the fundamental matrix and point sets are of double type
F = double(F);
if isa(matchedPoints1, 'cornerPoints')
    points1_h = [matchedPoints1.Location, ones(size(matchedPoints1.Location, 1), 1)];
    points2_h = [matchedPoints2.Location, ones(size(matchedPoints2.Location, 1), 1)];
elseif ismatrix(matchedPoints1)
    points1_h = [matchedPoints1, ones(size(matchedPoints1, 1), 1)];
    points2_h = [matchedPoints2, ones(size(matchedPoints2, 1), 1)];
else
    error('Unsupported data type for matched points.');
end

% Compute the epipolar lines
epiLines1 = (F' * points2_h')'; % Epipolar lines for points in image 2 in image 1
epiLines2 = (F * points1_h')'; % Epipolar lines for points in image 1 in image 2

% Create a figure and visualize the matched points and epipolar lines
figureHandle = figure;
subplot(1, 2, 1);
imshow(img1); hold on; title('Epipolar Lines in First Image');
plot(points1_h(:, 1), points1_h(:, 2), 'go'); % Plot the matched points
for i = 1:size(epiLines1, 1)
    lineEq = epiLines1(i, :);
    % Check the validity of the epipolar line equation
    if any(isnan(lineEq)) || all(lineEq(1:2) == 0)
        disp(['Invalid epipolar line for point ', num2str(i)]);
        continue;
    end
    linePoints = lineToBorderPoints(lineEq, size(img1));
    % Ensure linePoints is a 1x4 matrix
    if numel(linePoints) == 4
        % Plot the epipolar line
        line([linePoints(1), linePoints(3)], [linePoints(2), linePoints(4)], 'Color', 'r', 'LineWidth', 0.5);
    else
        disp(['Invalid line points for epipolar line ', num2str(i)]);
    end
end
hold off;

subplot(1, 2, 2);
imshow(img2); hold on; title('Epipolar Lines in Second Image');
plot(points2_h(:, 1), points2_h(:, 2), 'go'); % Plot the matched points
for i = 1:size(epiLines2, 1)
    lineEq = epiLines2(i, :);
    % Check the validity of the epipolar line equation
    if any(isnan(lineEq)) || all(lineEq(1:2) == 0)
        disp(['Invalid epipolar line for point ', num2str(i)]);
        continue;
    end
    linePoints = lineToBorderPoints(lineEq, size(img2));
    % Ensure linePoints is a 1x4 matrix
    if numel(linePoints) == 4
        % Plot the epipolar line
        line([linePoints(1), linePoints(3)], [linePoints(2), linePoints(4)], 'Color', 'r', 'LineWidth', 0.5);
    else
        disp(['Invalid line points for epipolar line ', num2str(i)]);
    end
end
hold off;

% Dynamically generate the file name
fileName = sprintf('epilines_%s', methodName);

% Save the file
outputDir = './temp_results/'; % Directory to save results
if ~exist(outputDir, 'dir')
    mkdir(outputDir); % Create the directory if it does not exist
end

% Save as a PNG file
savePath = fullfile(outputDir, [fileName, '.png']);
exportgraphics(figureHandle, savePath, 'Resolution', 600);

% Close the figure to avoid memory usage
close(figureHandle);

end