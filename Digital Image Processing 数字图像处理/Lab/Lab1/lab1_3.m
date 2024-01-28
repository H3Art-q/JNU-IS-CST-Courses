% Read the image
spineImage = imread('lab1_images/spine.tif');
spineImageDouble = im2double(spineImage); % Convert to double for processing

% Initialize figure
figure;

% Display original image
subplot(4, 4, 1);
imshow(spineImage);
title('Original Spine Image');

% Use the log transformation to enhance
for c = 1:3
    logTransformed = c * log(1 + spineImageDouble);
    
    % Display the log transformed images
    subplot(4, 4, c+1);
    imshow(logTransformed);
    title(['Log Transf. c = ', num2str(c)]);
end

% Use a power-law transformation
gammaValues = 0.4:0.4:1.6;
for gammaIndex = 1:length(gammaValues)
    gamma = gammaValues(gammaIndex);
    for c = 1:3
        gammaTransformed = c * (spineImageDouble .^ gamma);

        % Display the gamma transformed images
        subplotIndex = 4 + (gammaIndex - 1) * 3 + c;
        subplot(4, 4, subplotIndex);
        imshow(gammaTransformed);
        title(['Gamma Transf. c = ', num2str(c), ', γ = ', num2str(gamma)]);
    end
end
