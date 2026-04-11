package com.bumptech.glide.load.data;

import android.os.ParcelFileDescriptor;
import g7.x;
import java.io.InputStream;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements f {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final g f2234x = new g(0);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f2235v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f2236w;

    public h() {
        this.f2235v = 0;
        this.f2236w = new HashMap();
    }

    @Override // com.bumptech.glide.load.data.f
    public void b() {
        switch (this.f2235v) {
            case 1:
            case 2:
                break;
            default:
                ((x) this.f2236w).g();
                break;
        }
    }

    @Override // com.bumptech.glide.load.data.f
    public Object c() {
        switch (this.f2235v) {
            case 1:
                return ((ParcelFileDescriptorRewinder$InternalRewinder) this.f2236w).rewind();
            case 2:
                return this.f2236w;
            default:
                x xVar = (x) this.f2236w;
                xVar.reset();
                return xVar;
        }
    }

    public ParcelFileDescriptor e() {
        return ((ParcelFileDescriptorRewinder$InternalRewinder) this.f2236w).rewind();
    }

    public h(InputStream inputStream, a7.g gVar) {
        this.f2235v = 3;
        x xVar = new x(inputStream, gVar);
        this.f2236w = xVar;
        xVar.mark(5242880);
    }

    public h(ParcelFileDescriptor parcelFileDescriptor) {
        this.f2235v = 1;
        this.f2236w = new ParcelFileDescriptorRewinder$InternalRewinder(parcelFileDescriptor);
    }

    public h(Object obj) {
        this.f2235v = 2;
        this.f2236w = obj;
    }

    private final void a() {
    }

    private final void d() {
    }
}
