function ImageSlice()
    % 读取图像
    img = imread('selfie.jpg');
    
    % 转换为灰度图像
    if size(img, 3) == 3
        img_gray = rgb2gray(img);
    else
        img_gray = img;
    end
    
    % 将图像转换为8bit灰度图像
    img_8bit = im2uint8(img_gray);
    
    % 保存8bit灰度图像
    imwrite(img_8bit, fullfile('./Modified_images/', '8bit_gray_image.png'));

    % 为每个bit层次进行比特平面切片
    for k = 1:8
        % 提取第k个比特
        bit_img = uint8(bitget(img_8bit, k) * 255);
        
        % 保存比特平面图像
        imwrite(bit_img, fullfile('./Modified_images/', sprintf('bit_layer_%d.png', k)));
    end
end
