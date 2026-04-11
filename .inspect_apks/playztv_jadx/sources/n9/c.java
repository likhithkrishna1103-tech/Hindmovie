package n9;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends android.support.v4.media.session.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f8857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextPaint f8858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ android.support.v4.media.session.b f8859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d f8860d;

    public c(d dVar, Context context, TextPaint textPaint, android.support.v4.media.session.b bVar) {
        this.f8860d = dVar;
        this.f8857a = context;
        this.f8858b = textPaint;
        this.f8859c = bVar;
    }

    @Override // android.support.v4.media.session.b
    public final void I(int i) {
        this.f8859c.I(i);
    }

    @Override // android.support.v4.media.session.b
    public final void J(Typeface typeface, boolean z2) {
        this.f8860d.g(this.f8857a, this.f8858b, typeface);
        this.f8859c.J(typeface, z2);
    }
}
