package com.xw.repo;

import java.math.BigDecimal;

/**
 * Created by ewojahn on 07.12.17.
 */

public class DefaultBubbleValueToTextConverter implements BubbleSeekBar.BubbleValueToTextConverter {
    @Override
    public String convertValueToText(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, Boolean isShowProgressInFloat) {
        return isShowProgressInFloat ?
               String.valueOf(progressFloat) : String.valueOf(progress);
    }

    @Override
    public String getLongestText(BubbleSeekBar bubbleSeekBar, float min, float max, boolean isShowProgressInFloat, boolean isRtl, boolean isFloatType) {
        String text;
        if (isShowProgressInFloat) {
            text = float2String(isRtl ? max : min);
        } else {
            if (isRtl) {
                text = isFloatType ? float2String(max) : String.valueOf((int) max);
            } else {
                text = isFloatType ? float2String(min) : String.valueOf((int) min);
            }
        }
        return text;
    }

    private String float2String(float value) {
        return String.valueOf(formatFloat(value));
    }

    private float formatFloat(float value) {
        BigDecimal bigDecimal = BigDecimal.valueOf(value);
        return bigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
    }

}
