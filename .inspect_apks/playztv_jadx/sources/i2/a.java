package i2;

import android.graphics.Bitmap;
import y1.h;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Bitmap f6186u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ b f6187v;

    public a(b bVar) {
        this.f6187v = bVar;
    }

    @Override // y1.h, y1.a
    public final void clear() {
        this.f6186u = null;
        super.clear();
    }

    @Override // y1.h
    public final void release() {
        this.f6187v.j(this);
    }
}
