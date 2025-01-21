clc;
clear;

% Read images
I1 = imread('Source/image_1_o.jpg'); % Source image
I2 = imread('Source/image_1_f.jpg'); % Target image

% Select feature points in the source and target images
numPoints = 4;
figure; imshow(I1);
[x1, y1] = ginput(numPoints);
figure; imshow(I2);
[x2, y2] = ginput(numPoints);

% Define normalization function
normalizePoints = @(pts) deal(mean(pts, 1), std(pts(:)), (pts - mean(pts, 1)) / std(pts(:)));

% Normalize source and target points
[mean1, std1, normPts1] = normalizePoints([x1, y1]);
[mean2, std2, normPts2] = normalizePoints([x2, y2]);

% Construct normalization matrices T
T1 = [1/std1, 0, -mean1(1)/std1; 0, 1/std1, -mean1(2)/std1; 0, 0, 1];
T2 = [1/std2, 0, -mean2(1)/std2; 0, 1/std2, -mean2(2)/std2; 0, 0, 1];

% Construct the DLT matrix A (using normalized points)
A = [];
for i = 1:numPoints
    x1n = normPts1(i, 1);
    y1n = normPts1(i, 2);
    x2n = normPts2(i, 1);
    y2n = normPts2(i, 2);
    A = [A; 
         -x1n -y1n -1 0 0 0 x1n*x2n y1n*x2n x2n;
          0 0 0 -x1n -y1n -1 x1n*y2n y1n*y2n y2n];
end

% Compute normalized H
[~, ~, V] = svd(A);
H_normalized = reshape(V(:, end), 3, 3)';
H_normalized = H_normalized / H_normalized(3, 3);

% Denormalize H
H = inv(T2) * H_normalized * T1;
H = H / H(3, 3);

% Create projective2d object and apply the transformation
H_projective = projective2d(H');
outputImage = imwarp(I1, H_projective, 'OutputView', imref2d(size(I2)));

% Display results
figure;
subplot(1, 2, 1), imshow(I1), title('Original Image');
subplot(1, 2, 2), imshow(outputImage), title('Transformed Image using Normalized DLT');
