package ba;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1841b;

    public /* synthetic */ a(int i, Object obj) {
        this.f1840a = i;
        this.f1841b = obj;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public boolean canApplyTheme() {
        switch (this.f1840a) {
            case 2:
                return ((Drawable.ConstantState) this.f1841b).canApplyTheme();
            default:
                return super.canApplyTheme();
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        switch (this.f1840a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return 0;
            case 1:
                return 0;
            default:
                return ((Drawable.ConstantState) this.f1841b).getChangingConfigurations();
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        switch (this.f1840a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return (b) this.f1841b;
            case 1:
                return new k7.b(this);
            default:
                m5.d dVar = new m5.d(null, 0);
                Drawable drawableNewDrawable = ((Drawable.ConstantState) this.f1841b).newDrawable();
                dVar.f8321v = drawableNewDrawable;
                drawableNewDrawable.setCallback(dVar.A);
                return dVar;
        }
    }

    public a(b bVar) {
        this.f1840a = 0;
        this.f1841b = bVar;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        switch (this.f1840a) {
            case 1:
                return new k7.b(this);
            case 2:
                m5.d dVar = new m5.d(null, 0);
                Drawable drawableNewDrawable = ((Drawable.ConstantState) this.f1841b).newDrawable(resources);
                dVar.f8321v = drawableNewDrawable;
                drawableNewDrawable.setCallback(dVar.A);
                return dVar;
            default:
                return super.newDrawable(resources);
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources, Resources.Theme theme) {
        switch (this.f1840a) {
            case 2:
                m5.d dVar = new m5.d(null, 0);
                Drawable drawableNewDrawable = ((Drawable.ConstantState) this.f1841b).newDrawable(resources, theme);
                dVar.f8321v = drawableNewDrawable;
                drawableNewDrawable.setCallback(dVar.A);
                return dVar;
            default:
                return super.newDrawable(resources, theme);
        }
    }
}
