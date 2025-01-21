function interactive_epipolar_lines(F, img1, img2)
% Create a side-by-side layout with two subplots
figure;
subplot(1, 2, 1); % Subplot 1
imshow(img1); title('Click a point to view its epipolar line');
subplot(1, 2, 2); % Subplot 2
imshow(img2); title('Epipolar Line in Second Image');

% Infinite interactive loop
while true
    % User clicks a point in the first image
    subplot(1, 2, 1);
    [x, y, button] = ginput(1); % Get the clicked point and mouse button
    % Check if "Enter" or "Esc" key is pressed to exit
    if isempty(x) || button == 27 % Press Enter or Esc to exit
        disp('Exiting interactive mode.');
        break;
    end
    
    % Convert to homogeneous coordinates
    clickedPoint = [x, y, 1];
    
    % Compute the corresponding epipolar line in image 2
    epiLine2 = clickedPoint * F; % Epipolar line for the clicked point in image 2
    borderPts2 = lineToBorderPoints(epiLine2, size(img2)); % Intersection points of the epipolar line with the image 2 borders
    
    % Compute the epipolar line in image 1 (mapping from image 2 to image 1)
    epiLine1 = (F' * clickedPoint')'; % Transpose to ensure it's a 1x3 row vector
    borderPts1 = lineToBorderPoints(epiLine1, size(img1)); % Intersection points of the epipolar line with the image 1 borders
    
    % Plot the clicked point and epipolar line in image 1
    subplot(1, 2, 1);
    hold on;
    plot(x, y, 'go', 'MarkerSize', 10, 'LineWidth', 2); % Mark the clicked point
    line(borderPts1(:, [1, 3])', borderPts1(:, [2, 4])', 'Color', 'b', 'LineWidth', 1.5); % Draw the epipolar line
    hold off;
    
    % Plot the corresponding epipolar line in image 2
    subplot(1, 2, 2);
    hold on;
    line(borderPts2(:, [1, 3])', borderPts2(:, [2, 4])', 'Color', 'r', 'LineWidth', 1.5); % Draw the epipolar line
    hold off;
end
end