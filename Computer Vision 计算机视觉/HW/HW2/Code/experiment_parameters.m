function experiment_parameters(img1, img2)
% Define the range of experimental parameters
minQualityValues = [0.01, 0.03, 0.05];
maxRatioValues = [0.6, 0.8, 1.0];

% Iterate through all combinations of parameters
for minQuality = minQualityValues
    for maxRatio = maxRatioValues
        disp(['Experimenting with MinQuality: ', num2str(minQuality), ...
            ' and MaxRatio: ', num2str(maxRatio)]);
        
        % Call the feature detection and matching function
        [matchedPoints1, matchedPoints2] = feature_matching(img1, img2, minQuality, maxRatio);
        
        % Check the number of matched points
        numMatches = size(matchedPoints1, 1);
        if numMatches < 7
            % Does not meet the requirement for the 7-point algorithm
            disp(['Not enough matches for fundamental matrix estimation. At least 7 matches are required.', newline]);
            continue;
        elseif numMatches == 7
            % Call the 7-point algorithm
            disp('Using the 7-point algorithm for fundamental matrix estimation.');
            F7 = seven_point_algorithm(matchedPoints1.Location, matchedPoints2.Location);
            residual7 = compute_residual_error(F7, matchedPoints1, matchedPoints2);
            disp(['Residual Error (7-point): ', num2str(residual7), newline]);
        elseif numMatches >= 8
            % Call the normalized 8-point algorithm
            disp('Using the normalized 8-point algorithm for fundamental matrix estimation.');
            F8 = normalized_eight_point(matchedPoints1.Location, matchedPoints2.Location);
            residual8 = compute_residual_error(F8, matchedPoints1, matchedPoints2);
            disp(['Residual Error (8-point): ', num2str(residual8), newline]);
        end
    end
end
end