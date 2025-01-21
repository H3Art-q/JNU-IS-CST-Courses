clc;
clear;

% Load images
img1 = imread('./Source/image_1_a.jpg');
img2 = imread('./Source/image_1_b.jpg');

% Feature detection and matching
[matchedPoints1, matchedPoints2] = feature_matching(img1, img2);

% Check the number of matched points
if size(matchedPoints1, 1) < 7
    error('Not enough matched points. At least 7 matches are required.');
end

% Fundamental matrix computation
if size(matchedPoints1, 1) == 7
    % 7-point algorithm
    F_initial = seven_point_algorithm(matchedPoints1.Location, matchedPoints2.Location);
    visualize_epipolar_lines(F_initial, matchedPoints1, matchedPoints2, img1, img2, '7-point');
    disp('7-point algorithm result:');
elseif size(matchedPoints1, 1) >= 8
    % Normalized 8-point algorithm
    F_initial = normalized_eight_point(matchedPoints1.Location, matchedPoints2.Location);
    visualize_epipolar_lines(F_initial, matchedPoints1, matchedPoints2, img1, img2, 'normalized_8-point');
    disp('Normalized 8-point algorithm result:');
else
    error('Not enough matched points. At least 7 matches are required.');
end

% Compute the initial residual error
residual_initial = compute_residual_error(F_initial, matchedPoints1, matchedPoints2);
disp(['Initial Residual Error: ', num2str(residual_initial), newline]);

% RANSAC
[F_ransac, inlierPoints1, inlierPoints2] = ransac_fundamental_matrix(...
    matchedPoints1.Location, matchedPoints2.Location, 2000, 1);
visualize_epipolar_lines(F_initial, inlierPoints1, inlierPoints2, img1, img2, 'RANSAC');
disp('RANSAC result:');
residual_ransac = compute_residual_error(F_ransac, inlierPoints1, inlierPoints2);
disp(['Residual Error (RANSAC): ', num2str(residual_ransac), newline]);

% Nonlinear optimization
F_optimized = nonlinear_optimization(F_ransac, inlierPoints1, inlierPoints2);
visualize_epipolar_lines(F_initial, inlierPoints1, inlierPoints2, img1, img2, 'optimized');
disp('Optimized Fundamental Matrix:');
residual_optimized = compute_residual_error(F_optimized, inlierPoints1, inlierPoints2);
disp(['Residual Error (Optimized): ', num2str(residual_optimized), newline]);

% Results
disp('Optimized Fundamental Matrix:');
disp(F_optimized);

% Find more matches along epipolar lines
find_matches_along_epilines(F_optimized, img1, img2, inlierPoints1, inlierPoints2);

% Parameter experimentation
experiment_parameters(img1, img2);

% Epipolar line visualization
interactive_epipolar_lines(F_optimized, img1, img2);