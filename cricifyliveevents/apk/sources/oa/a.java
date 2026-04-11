package oa;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.tabs.TabLayout;
import f9.z;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends z {
    public final /* synthetic */ int H;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(int i) {
        super(20);
        this.H = i;
    }

    @Override // f9.z
    public final void s(TabLayout tabLayout, View view, View view2, float f, Drawable drawable) {
        float fSin;
        float fCos;
        switch (this.H) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                RectF rectFI = z.i(tabLayout, view);
                RectF rectFI2 = z.i(tabLayout, view2);
                if (rectFI.left < rectFI2.left) {
                    double d10 = (((double) f) * 3.141592653589793d) / 2.0d;
                    fSin = (float) (1.0d - Math.cos(d10));
                    fCos = (float) Math.sin(d10);
                } else {
                    double d11 = (((double) f) * 3.141592653589793d) / 2.0d;
                    fSin = (float) Math.sin(d11);
                    fCos = (float) (1.0d - Math.cos(d11));
                }
                drawable.setBounds(l9.a.c(fSin, (int) rectFI.left, (int) rectFI2.left), drawable.getBounds().top, l9.a.c(fCos, (int) rectFI.right, (int) rectFI2.right), drawable.getBounds().bottom);
                break;
            default:
                if (f >= 0.5f) {
                    view = view2;
                }
                RectF rectFI3 = z.i(tabLayout, view);
                float fB = f < 0.5f ? l9.a.b(1.0f, 0.0f, 0.0f, 0.5f, f) : l9.a.b(0.0f, 1.0f, 0.5f, 1.0f, f);
                drawable.setBounds((int) rectFI3.left, drawable.getBounds().top, (int) rectFI3.right, drawable.getBounds().bottom);
                drawable.setAlpha((int) (fB * 255.0f));
                break;
        }
    }
}
