function F = normalized_eight_point(points1, points2)
[points1_norm, T1] = normalize_points(points1);
[points2_norm, T2] = normalize_points(points2);
A = [points2_norm(:,1).*points1_norm(:,1), points2_norm(:,1).*points1_norm(:,2), points2_norm(:,1), ...
    points2_norm(:,2).*points1_norm(:,1), points2_norm(:,2).*points1_norm(:,2), points2_norm(:,2), ...
    points1_norm(:,1), points1_norm(:,2), ones(size(points1_norm, 1), 1)];
[~, ~, V] = svd(A);
F_norm = reshape(V(:,end), [3, 3]);
[U, S, V] = svd(F_norm);
S(3,3) = 0;
F_norm = U * S * V';
F = T2' * F_norm * T1;
end

function [points_norm, T] = normalize_points(points)
centroid = mean(points);
scale = sqrt(2) / mean(sqrt(sum((points - centroid).^2, 2)));
T = [scale, 0, -scale * centroid(1); 0, scale, -scale * centroid(2); 0, 0, 1];
points_h = [points, ones(size(points, 1), 1)];
points_norm_h = (T * points_h')';
points_norm = points_norm_h(:, 1:2);
end