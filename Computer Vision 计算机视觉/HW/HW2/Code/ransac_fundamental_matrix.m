function [F_ransac, inlierPoints1, inlierPoints2] = ransac_fundamental_matrix(points1, points2, numIterations, distanceThreshold)
numPoints = size(points1, 1);
maxInliers = 0;
F_ransac = [];
points1_h = [points1, ones(numPoints, 1)];
points2_h = [points2, ones(numPoints, 1)];
for i = 1:numIterations
    randomIndices = randperm(numPoints, 8);
    samplePoints1 = points1(randomIndices, :);
    samplePoints2 = points2(randomIndices, :);
    F_candidate = normalized_eight_point(samplePoints1, samplePoints2);
    distances = compute_epipolar_distances(F_candidate, points1_h, points2_h);
    inliers = find(distances < distanceThreshold);
    numInliers = length(inliers);
    if numInliers > maxInliers
        maxInliers = numInliers;
        F_ransac = F_candidate;
        bestInliers = inliers;
    end
end
inlierPoints1 = points1(bestInliers, :);
inlierPoints2 = points2(bestInliers, :);
end

function distances = compute_epipolar_distances(F, points1, points2)
epiLines1 = (F' * points2')';
epiLines2 = (F * points1')';
dist1 = abs(sum(points1 .* epiLines1, 2)) ./ sqrt(epiLines1(:, 1).^2 + epiLines1(:, 2).^2);
dist2 = abs(sum(points2 .* epiLines2, 2)) ./ sqrt(epiLines2(:, 1).^2 + epiLines2(:, 2).^2);
distances = dist1 + dist2;
end
