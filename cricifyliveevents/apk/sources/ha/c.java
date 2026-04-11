package ha;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends com.bumptech.glide.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f5852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextPaint f5853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bumptech.glide.d f5854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d f5855d;

    public c(d dVar, Context context, TextPaint textPaint, com.bumptech.glide.d dVar2) {
        this.f5855d = dVar;
        this.f5852a = context;
        this.f5853b = textPaint;
        this.f5854c = dVar2;
    }

    @Override // com.bumptech.glide.d
    public final void w(int i) {
        this.f5854c.w(i);
    }

    @Override // com.bumptech.glide.d
    public final void x(Typeface typeface, boolean z10) {
        this.f5855d.f(this.f5852a, this.f5853b, typeface);
        this.f5854c.x(typeface, z10);
    }
}
