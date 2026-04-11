package h5;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f5886b;

    public /* synthetic */ e(int i, Object obj) {
        this.f5885a = i;
        this.f5886b = obj;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public boolean canApplyTheme() {
        switch (this.f5885a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((Drawable.ConstantState) this.f5886b).canApplyTheme();
            default:
                return super.canApplyTheme();
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        switch (this.f5885a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((Drawable.ConstantState) this.f5886b).getChangingConfigurations();
            case 1:
                return 0;
            default:
                return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        switch (this.f5885a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                f fVar = new f(null, 0);
                Drawable drawableNewDrawable = ((Drawable.ConstantState) this.f5886b).newDrawable();
                fVar.f5895u = drawableNewDrawable;
                drawableNewDrawable.setCallback(fVar.f5891z);
                return fVar;
            case 1:
                return (h9.a) this.f5886b;
            default:
                return new p6.b(this);
        }
    }

    public e(h9.a aVar) {
        this.f5885a = 1;
        this.f5886b = aVar;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        switch (this.f5885a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                f fVar = new f(null, 0);
                Drawable drawableNewDrawable = ((Drawable.ConstantState) this.f5886b).newDrawable(resources);
                fVar.f5895u = drawableNewDrawable;
                drawableNewDrawable.setCallback(fVar.f5891z);
                return fVar;
            case 1:
            default:
                return super.newDrawable(resources);
            case 2:
                return new p6.b(this);
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources, Resources.Theme theme) {
        switch (this.f5885a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                f fVar = new f(null, 0);
                Drawable drawableNewDrawable = ((Drawable.ConstantState) this.f5886b).newDrawable(resources, theme);
                fVar.f5895u = drawableNewDrawable;
                drawableNewDrawable.setCallback(fVar.f5891z);
                return fVar;
            default:
                return super.newDrawable(resources, theme);
        }
    }
}
