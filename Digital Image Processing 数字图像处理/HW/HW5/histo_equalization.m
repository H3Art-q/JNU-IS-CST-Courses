% Digital Image Processing HW 5

% 读取图像
img = imread('Fig0326(a)(embedded_square_noisy_512).tif');
if size(img,3) > 1
    img = rgb2gray(img);
end

% 应用全局直方图均衡化
global_histeq = histeq(img);

% 应用3x3邻域的局部直方图均衡化（利用adapthisteq，速度快，但效果不好）
% local_histeq = adapthisteq(img, "NumTiles",[3 3]);

% 应用3x3邻域的局部直方图均衡化（利用histeq，速度慢，但效果好一些）
[M, N] = size(img);
local_histeq = zeros(M, N, 'uint8');

% 遍历图像中的每一个3x3的邻域
for i = 2:M-1
    for j = 2:N-1
        block = img(i-1:i+1, j-1:j+1);
        eq_block = histeq(block);
        local_histeq(i,j) = eq_block(2,2);
    end
end

% 显示结果
figure;
subplot(1,3,1);
imshow(img);
title('原始图像');

subplot(1,3,2);
imshow(global_histeq);
title('全局直方图均衡化结果');

subplot(1,3,3);
imshow(local_histeq);
title('3x3邻域局部直方图均衡化结果');