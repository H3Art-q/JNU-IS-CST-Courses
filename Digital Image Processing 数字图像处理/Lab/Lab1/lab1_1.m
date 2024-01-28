% Read the images
tire_img = imread('lab1_images/tire.tif');
rice_img = imread('lab1_images/rice.png');

% Display the tire image in one figure
figure; imshow(tire_img); title('Tire Image');
figure; imshow(rice_img); title('Rice Image');

% Display both images in a separate figure using subplots
figure;
subplot(1,2,1); imshow(tire_img); title('Tire Image');
subplot(1,2,2); imshow(rice_img); title('Rice Image');

% Using size
tire_size = size(tire_img);
rice_size = size(rice_img);

% Using imfinfo
tire_info = imfinfo('tire.tif');
rice_info = imfinfo('rice.png');

% Using whos
whos tire_img
whos rice_img

f = imread('lab1_images/tire.tif');
figure; imshow(f);
set(figure(4),'NumberTitle','off','Name','my first image')

% Create the folder if it doesn't exist
folder_path = 'imagetest';
if ~exist(folder_path, 'dir')
    mkdir(folder_path);
end

% Save the image
imwrite(tire_img, fullfile(folder_path, 'tire.tif'));
