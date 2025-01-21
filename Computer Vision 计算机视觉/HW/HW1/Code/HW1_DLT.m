clc;
clear;

I1 = imread('Source/image_1_o.jpg'); % Source image
I2 = imread('Source/image_1_f.jpg'); % Target image

% Select feature points in the source and target images
numPoints = 4;
figure; imshow(I1);
[x1, y1] = ginput(numPoints);
figure; imshow(I2);
[x2, y2] = ginput(numPoints);

% x1 = [74; 124; 128; 70];
% y1 = [45; 43; 77; 77];
% x2 = [62; 106; 106; 62];
% y2 = [55; 57; 101; 101];

% Construct the DLT matrix A
A = [];
for i = 1:numPoints
    A = [A; 
         -x1(i) -y1(i) -1 0 0 0 x1(i)*x2(i) y1(i)*x2(i) x2(i);
          0 0 0 -x1(i) -y1(i) -1 x1(i)*y2(i) y1(i)*y2(i) y2(i)];
end

% Compute the homography matrix H using SVD
[~, ~, V] = svd(A);
H = reshape(V(:, end), 3, 3)'; % Use the last column of V as H

% Normalize H
H = H / H(3, 3);

% Create projective2d object and apply the transformation
H_projective = projective2d(H');
outputImage = imwarp(I1, H_projective, 'OutputView', imref2d(size(I2)));

% Display results
figure;
subplot(1, 2, 1), imshow(I1), title('Original Image');
subplot(1, 2, 2), imshow(outputImage), title('Transformed Image');
