function residualError = compute_residual_error(F, matchedPoints1, matchedPoints2)
% Ensure the fundamental matrix and point sets are of type double
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

% Compute the symmetrical epipolar distance for the points to the epipolar lines
epiLines1 = (F' * points2_h')'; % Epipolar lines for points in image 2 in image 1
epiLines2 = (F * points1_h')'; % Epipolar lines for points in image 1 in image 2

% Distance calculation (normalized)
dist1 = abs(sum(points1_h .* epiLines1, 2)) ./ sqrt(epiLines1(:, 1).^2 + epiLines1(:, 2).^2);
dist2 = abs(sum(points2_h .* epiLines2, 2)) ./ sqrt(epiLines2(:, 1).^2 + epiLines2(:, 2).^2);

% Average residual of the symmetrical epipolar distance
residualError = mean(dist1 + dist2);

% Output the residual
disp(['Symmetrical Epipolar Residual Error: ', num2str(residualError)]);
end