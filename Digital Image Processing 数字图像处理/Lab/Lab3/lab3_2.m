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

% Initialize low-pass filter masks
ILPF_mask = zeros(M, N);
BLPF_mask = zeros(M, N);
GLPF_mask = zeros(M, N);

% Create a grid of distances from the center of the frequency rectangle
[u, v] = meshgrid(-floor(N/2):floor((N-1)/2), -floor(M/2):floor((M-1)/2));
D = sqrt(u.^2 + v.^2);

% Set the cut-off frequencies
cutoff_frequencies = [5, 10, 50];

for D0 = cutoff_frequencies
    % Create the Ideal Low-Pass Filter (ILPF) mask
    ILPF_mask(D <= D0) = 1;

    % Create the Butterworth Low-Pass Filter (BLPF) mask
    n = 2; % Order of the filter
    BLPF_mask = 1 ./ (1 + (D./D0).^(2*n));

    % Create the Gaussian Low-Pass Filter (GLPF) mask
    GLPF_mask = exp(-(D.^2)./(2*(D0^2)));

    % Apply the filters by multiplying in the frequency domain
    ILPF_result = F_shifted .* ILPF_mask;
    BLPF_result = F_shifted .* BLPF_mask;
    GLPF_result = F_shifted .* GLPF_mask;

    % Perform inverse Fourier transform to get the filtered images
    img_ILPF = real(ifft2(ifftshift(ILPF_result)));
    img_BLPF = real(ifft2(ifftshift(BLPF_result)));
    img_GLPF = real(ifft2(ifftshift(GLPF_result)));

    % Display the filtered images
    figure;
    subplot(1, 4, 1), imshow(img_gray), title('Original Image');
    subplot(1, 4, 2), imshow(img_ILPF, []), title('ILPF Image');
    subplot(1, 4, 3), imshow(img_BLPF, []), title('BLPF Image');
    subplot(1, 4, 4), imshow(img_GLPF, []), title('GLPF Image');

    % print out the cut-off frequency of present loop
    fprintf('The cut-off frequency is %d.\n', D0);
end