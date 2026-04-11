package o2;

import android.graphics.Bitmap;
import e2.h;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends h {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Bitmap f9423v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ b f9424w;

    public a(b bVar) {
        this.f9424w = bVar;
    }

    @Override // e2.h, e2.a
    public final void clear() {
        this.f9423v = null;
        super.clear();
    }

    @Override // e2.h
    public final void release() {
        this.f9424w.j(this);
    }
}
