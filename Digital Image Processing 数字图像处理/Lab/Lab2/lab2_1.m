% Read the image
tireImage = imread('lab2_images/tire.tif');

% Show the image
figure, imshow(tireImage), title('Original Tire Image');

% Show the histogram of the original image
figure, imhist(tireImage), title('Histogram of Original Tire Image');

% Perform histogram equalization
equalizedImage = histeq(tireImage);

% Show the histogram equalized image
figure, imshow(equalizedImage), title('Histogram Equalized Tire Image');

% Show the histogram of the histogram equalized image
figure, imhist(equalizedImage), title('Histogram of Equalized Tire Image');

% Visual comparison using subplot
figure;

% Original Image
subplot(2, 2, 1), imshow(tireImage), title('Original Tire Image');

% Histogram of Original Image
subplot(2, 2, 2), imhist(tireImage), title('Histogram of Original Tire Image');

% Equalized Image
subplot(2, 2, 3), imshow(equalizedImage), title('Histogram Equalized Tire Image');

% Histogram of Equalized Image
subplot(2, 2, 4), imhist(equalizedImage), title('Histogram of Equalized Tire Image');
