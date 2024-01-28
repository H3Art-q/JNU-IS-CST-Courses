clc;
clear;

% Read the image
img = imread('lab3_images/selfie.jpg');

% Convert to grayscale
if size(img, 3) == 3
    img_gray = rgb2gray(img);
else
    img_gray = img;
end

% Perform Fourier transform
F = fft2(double(img_gray));
F_shifted = fftshift(F);

% Define the size of the image
[M, N] = size(F_shifted);

% Initialize high-pass filter masks
IHPF_mask = zeros(M, N);
BHPF_mask = zeros(M, N);
GHPF_mask = zeros(M, N);

% Create a grid of distances from the center of the frequency rectangle
[u, v] = meshgrid(-floor(N/2):floor((N-1)/2), -floor(M/2):floor((M-1)/2));
D = sqrt(u.^2 + v.^2);

% Set the cut-off frequency
cutoff_frequencies = [5, 10, 50];

for D0 = cutoff_frequencies
    % Create the Ideal High-Pass Filter (IHPF) mask
    IHPF_mask(D > D0) = 1;

    % Create the Butterworth High-Pass Filter (BHPF) mask
    n = 2; % Order of the filter
    BHPF_mask = 1 - 1 ./ (1 + (D./D0).^(2*n));

    % Create the Gaussian High-Pass Filter (GHPF) mask
    GHPF_mask = 1 - exp(-(D.^2)./(2*(D0^2)));

    % Apply the high-pass filters
    IHPF_result = F_shifted .* IHPF_mask;
    BHPF_result = F_shifted .* BHPF_mask;
    GHPF_result = F_shifted .* GHPF_mask;

    % Perform inverse Fourier transform to obtain the filtered images
    img_IHPF = real(ifft2(ifftshift(IHPF_result)));
    img_BHPF = real(ifft2(ifftshift(BHPF_result)));
    img_GHPF = real(ifft2(ifftshift(GHPF_result)));

    % Display the filtered images
    figure;
    subplot(1, 4, 1), imshow(img_gray), title('Original Image');
    subplot(1, 4, 2), imshow(img_IHPF, []), title('IHPF Image');
    subplot(1, 4, 3), imshow(img_BHPF, []), title('BHPF Image');
    subplot(1, 4, 4), imshow(img_GHPF, []), title('GHPF Image');

    % print out the cut-off frequency of present loop
    fprintf('The cut-off frequency is %d.\n', D0);
end