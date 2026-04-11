package com.bumptech.glide.load.data;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import java.util.HashMap;
import l6.v;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i implements g {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final h f2809w = new h(0);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f2810u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f2811v;

    public i() {
        this.f2810u = 0;
        this.f2811v = new HashMap();
    }

    @Override // com.bumptech.glide.load.data.g
    public Object a() {
        switch (this.f2810u) {
            case 1:
                return ((ParcelFileDescriptorRewinder$InternalRewinder) this.f2811v).rewind();
            case 2:
                return this.f2811v;
            default:
                v vVar = (v) this.f2811v;
                vVar.reset();
                return vVar;
        }
    }

    @Override // com.bumptech.glide.load.data.g
    public void b() {
        switch (this.f2810u) {
            case 1:
            case 2:
                break;
            default:
                ((v) this.f2811v).d();
                break;
        }
    }

    public ParcelFileDescriptor e() {
        return ((ParcelFileDescriptorRewinder$InternalRewinder) this.f2811v).rewind();
    }

    public i(InputStream inputStream, f6.f fVar) {
        this.f2810u = 3;
        v vVar = new v(inputStream, fVar);
        this.f2811v = vVar;
        vVar.mark(5242880);
    }

    public i(ParcelFileDescriptor parcelFileDescriptor) {
        this.f2810u = 1;
        this.f2811v = new ParcelFileDescriptorRewinder$InternalRewinder(parcelFileDescriptor);
    }

    public i(Object obj) {
        this.f2810u = 2;
        this.f2811v = obj;
    }

    private final void c() {
    }

    private final void d() {
    }
}
