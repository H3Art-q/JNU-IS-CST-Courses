function F_optimized = nonlinear_optimization(F, points1, points2)
% Ensure the fundamental matrix F is of double precision type
F = double(F);

% Ensure the point sets are of double precision type
points1 = double(points1);
points2 = double(points2);

% Convert the point sets to homogeneous coordinates
points1_h = [points1, ones(size(points1, 1), 1)];
points2_h = [points2, ones(size(points2, 1), 1)];

% Define the optimization objective function
fun = @(F_vec) compute_residual_error(reshape(F_vec, [3, 3]), points1_h, points2_h);

% Set optimization options
options = optimoptions('lsqnonlin', 'Display', 'off');

% Call lsqnonlin for optimization
F_vec = lsqnonlin(fun, F(:), [], [], options);

% The optimized fundamental matrix
F_optimized = reshape(F_vec, [3, 3]);
end

function residuals = compute_residual_error(F, points1, points2)
% Compute the symmetrical epipolar distance for points to epipolar lines
epiLines1 = (F' * points2')'; % Epipolar lines for points in image 2 in image 1
epiLines2 = (F * points1')'; % Epipolar lines for points in image 1 in image 2

% Compute the normalized distances
dist1 = abs(sum(points1 .* epiLines1, 2)) ./ sqrt(epiLines1(:, 1).^2 + epiLines1(:, 2).^2);
dist2 = abs(sum(points2 .* epiLines2, 2)) ./ sqrt(epiLines2(:, 1).^2 + epiLines2(:, 2).^2);

% Return the residuals
residuals = dist1 + dist2;
end