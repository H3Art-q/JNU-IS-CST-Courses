% Read the image
moonImage = imread('lab2_images/moon.tif');

% Show the image
figure, subplot(3, 2, 1), imshow(moonImage), title('Original Moon Image');

% Show the histogram of the original image
subplot(3, 2, 2), imhist(moonImage), title('Histogram of Original Moon Image');

% Perform histogram equalization
equalizedImage = histeq(moonImage);

% Show the histogram equalized image
subplot(3, 2, 3), imshow(equalizedImage), title('Equalized Moon Image');

% Show the histogram of the histogram equalized image
subplot(3, 2, 4), imhist(equalizedImage), title('Histogram of Equalized Moon Image');

% Specify the histogram H
H = ones(1, 256);
H(1) = 256; % Set the first value to 256

% Use histogram matching
matchedImage = histeq(moonImage, H);

% Show the histogram matched image
subplot(3, 2, 5), imshow(matchedImage), title('Histogram Matched Moon Image');

% Show the histogram of the histogram matched image
subplot(3, 2, 6), imhist(matchedImage), title('Histogram of Matched Moon Image');
