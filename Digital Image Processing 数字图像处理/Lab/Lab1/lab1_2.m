% Read the image
[originalImage, colormap] = imread('lab1_images/kids.tif');
originalRGBImage = ind2rgb(originalImage, colormap);

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%SHRINK%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% Specify the scale factor for shrinking
scaleFactor = 0.5;

% Perform nearest neighbor interpolation
shrinkNearest = imresize(originalRGBImage, scaleFactor, 'nearest');

% Perform bilinear interpolation
shrinkBilinear = imresize(originalRGBImage, scaleFactor, 'bilinear');

% Perform bicubic interpolation
shrinkBicubic = imresize(originalRGBImage, scaleFactor, 'bicubic');

% Display the images
figure, imshow(originalRGBImage), title('Original RGB Image');
figure, imshow(shrinkNearest), title('Shrink using Nearest Neighbor');
figure, imshow(shrinkBilinear), title('Shrink using Bilinear Interpolation');
figure, imshow(shrinkBicubic), title('Shrink using Bicubic Interpolation');

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%ZOOM BACK%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% Zoom the images back to original size
zoomNearest = imresize(shrinkNearest, 1/scaleFactor, 'nearest');
zoomBilinear = imresize(shrinkBilinear, 1/scaleFactor, 'bilinear');
zoomBicubic = imresize(shrinkBicubic, 1/scaleFactor, 'bicubic');

% Display the zoomed images
figure, imshow(zoomNearest), title('Zoom Nearest Neighbor');
figure, imshow(zoomBilinear), title('Zoom Bilinear Interpolation');
figure, imshow(zoomBicubic), title('Zoom Bicubic Interpolation');

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%CROP%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% Define the crop rectangle [x, y, width, height]
cropRect = [50, 50, 200, 200];

% Crop the image
croppedImage = imcrop(originalRGBImage, cropRect);

% Display the cropped image
figure, imshow(croppedImage), title('Cropped Image');

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%ROTATE%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% Specify the rotation angle in degrees
rotationAngle = 45;

% Rotate the image
rotatedImage = imrotate(originalRGBImage, rotationAngle);

% Display the rotated image
figure, imshow(rotatedImage), title('Rotated Image');
