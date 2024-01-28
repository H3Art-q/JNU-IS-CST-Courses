clc;
clear;

% Read the image
img1 = imread('dog.jpg');
img2 = imread('selfie.jpg');

% Convert to grayscale
if size(img1, 3) == 3
    img1_gray = rgb2gray(img1);
else
    img1_gray = img1;
end

if size(img2, 3) == 3
    img2_gray = rgb2gray(img2);
else
    img2_gray = img2;
end

% Get size of image
[rows1, cols1, ~] = size(img1_gray);
[rows2, cols2, ~] = size(img2_gray);

% Certain the uniform size
new_rows = min(rows1, rows2);
new_cols = min(cols1, cols2);

% Resize the images to ensure both of them have the same size
img1_resized = imresize(img1_gray, [new_rows new_cols]);
img2_resized = imresize(img2_gray, [new_rows new_cols]);

% Display the original gray images
figure, imshow(img1_resized), title('Image 1 Gray');
figure, imshow(img2_resized), title('Image 2 Gray');

% Perform Fourier transform
F1 = fft2(double(img1_resized));
F2 = fft2(double(img2_resized));

% Get the magnitude and phase angle information
F1_magnitude = abs(F1);
F1_phase = angle(F1);
F2_magnitude = abs(F2);
F2_phase = angle(F2);

% Combine an image's phase angle and another image's magnitude,
% then perform the inverse Fourier transform to reconstruct the image
img_combined1 = real(ifft2(F1_magnitude .* exp(1i * F2_phase)));
img_combined2 = real(ifft2(F2_magnitude .* exp(1i * F1_phase)));

% Display the reconstructed image
figure, imshow(img_combined1, []), title(['Combined Image from' ...
    ' Magnitude of Image 1 and Phase of Image 2']);
figure, imshow(img_combined2, []), title(['Combined Image from' ...
    ' Magnitude of Image 2 and Phase of Image 1']);
