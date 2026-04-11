package u9;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.tabs.TabLayout;
import k8.c0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends c0 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f12794v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(int i) {
        super(29);
        this.f12794v = i;
    }

    @Override // k8.c0
    public final void j(TabLayout tabLayout, View view, View view2, float f, Drawable drawable) {
        float fSin;
        float fCos;
        switch (this.f12794v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                RectF rectFG = c0.g(tabLayout, view);
                RectF rectFG2 = c0.g(tabLayout, view2);
                if (rectFG.left < rectFG2.left) {
                    double d10 = (((double) f) * 3.141592653589793d) / 2.0d;
                    fSin = (float) (1.0d - Math.cos(d10));
                    fCos = (float) Math.sin(d10);
                } else {
                    double d11 = (((double) f) * 3.141592653589793d) / 2.0d;
                    fSin = (float) Math.sin(d11);
                    fCos = (float) (1.0d - Math.cos(d11));
                }
                drawable.setBounds(q8.a.c(fSin, (int) rectFG.left, (int) rectFG2.left), drawable.getBounds().top, q8.a.c(fCos, (int) rectFG.right, (int) rectFG2.right), drawable.getBounds().bottom);
                break;
            default:
                if (f >= 0.5f) {
                    view = view2;
                }
                RectF rectFG3 = c0.g(tabLayout, view);
                float fB = f < 0.5f ? q8.a.b(1.0f, 0.0f, 0.0f, 0.5f, f) : q8.a.b(0.0f, 1.0f, 0.5f, 1.0f, f);
                drawable.setBounds((int) rectFG3.left, drawable.getBounds().top, (int) rectFG3.right, drawable.getBounds().bottom);
                drawable.setAlpha((int) (fB * 255.0f));
                break;
        }
    }
}
