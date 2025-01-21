function F = seven_point_algorithm(points1, points2)
points1_h = [points1, ones(size(points1, 1), 1)];
points2_h = [points2, ones(size(points2, 1), 1)];
A = [points2_h(:,1).*points1_h(:,1), points2_h(:,1).*points1_h(:,2), points2_h(:,1), ...
    points2_h(:,2).*points1_h(:,1), points2_h(:,2).*points1_h(:,2), points2_h(:,2), ...
    points1_h(:,1), points1_h(:,2), ones(size(points1_h, 1), 1)];
[~, ~, V] = svd(A);
F1 = reshape(V(:,end-1), [3, 3]);
F2 = reshape(V(:,end), [3, 3]);
syms lambda;
F = lambda * F1 + (1 - lambda) * F2;
eq = det(F);
lambdas = double(vpasolve(eq, lambda));
F = lambdas(1) * F1 + (1 - lambdas(1)) * F2;
F = F / norm(F);
end