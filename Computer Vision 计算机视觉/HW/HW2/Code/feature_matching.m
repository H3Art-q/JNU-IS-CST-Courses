function [matchedPoints1, matchedPoints2] = feature_matching(img1, img2, minQuality, maxRatio)
% If minQuality or maxRatio are not provided, use default values
if nargin < 3
    minQuality = 0.01; % Default corner quality threshold
end
if nargin < 4
    maxRatio = 0.8; % Default matching ratio threshold
end

% Convert to grayscale images
if size(img1, 3) == 3
    img1 = rgb2gray(img1);
end
if size(img2, 3) == 3
    img2 = rgb2gray(img2);
end

% Detect feature points
points1 = detectHarrisFeatures(img1, 'MinQuality', minQuality, 'FilterSize', 5);
points2 = detectHarrisFeatures(img2, 'MinQuality', minQuality, 'FilterSize', 5);

% Extract feature descriptors
[features1, validPoints1] = extractFeatures(img1, points1);
[features2, validPoints2] = extractFeatures(img2, points2);

% Match feature points
indexPairs = matchFeatures(features1, features2, 'MaxRatio', maxRatio);
matchedPoints1 = validPoints1(indexPairs(:, 1));
matchedPoints2 = validPoints2(indexPairs(:, 2));

% Visualize the initial matched points
figureHandle = figure; % Save the figure handle
showMatchedFeatures(img1, img2, matchedPoints1, matchedPoints2, 'montage');
title(['Feature Matching (minQuality=', num2str(minQuality), ', maxRatio=', num2str(maxRatio), ')']);

% Dynamically generate the file name
fileName = sprintf('feature_matching_min%.1e_max%.1e', minQuality, maxRatio);

% Save as a PNG and PDF without white borders
outputDir = './temp_results/'; % Directory to save results
if ~exist(outputDir, 'dir')
    mkdir(outputDir); % Create the directory if it does not exist
end

% Save as a PNG file
exportgraphics(figureHandle, fullfile(outputDir, [fileName, '.png']), 'Resolution', 600);

% Close the figure to avoid memory usage
close(figureHandle);
end