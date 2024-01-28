clc;
clear;

% Read the image
img = imread('lab3_images/bag.png');

% Convert to grayscale
if size(img, 3) == 3
    img_gray = rgb2gray(img);
else
    img_gray = img;
end

% Display the original grayscale image
figure, imshow(img_gray), title('Original Gray Image');

% Perform Fourier transform
F = fft2(double(img_gray));
F_shifted = fftshift(F);
F_magnitude = log(abs(F_shifted) + 1);  % Calculate the frequency magnitude
F_phase = angle(F_shifted);             % Calculate the phase angle

% Display the magnitude image
figure, imshow(F_magnitude, []), 
title('Magnitude Image');

% Display the phase angle image
figure, imshow(F_phase, []), 
title('Phase Angle Image');

% Reconstructed Image from Phase Only(Set magnitude as 1)
F_phase_only = 1 .* exp(1i * angle(F_shifted));
img_phase_only = real(ifft2(ifftshift(F_phase_only)));
figure, imshow(img_phase_only, []), 
title('Reconstructed Image from Phase Only');

% Reconstructed Image from Magnitude Only(Set phase angle as 0)
F_magnitude_only = abs(F_shifted) .* exp(1i * zeros(size(angle(F_shifted))));
img_magnitude_only = real(ifft2(ifftshift(F_magnitude_only)));
figure, imshow(img_magnitude_only, []), 
title('Reconstructed Image from Magnitude Only');

% Perform inverse Fourier transform
F_inverse = ifftshift(abs(F_shifted) .* exp(1i * angle(F_shifted)));
img_reconstructed = real(ifft2(F_inverse));
figure, imshow(img_reconstructed, []), 
title('Reconstructed Image');
