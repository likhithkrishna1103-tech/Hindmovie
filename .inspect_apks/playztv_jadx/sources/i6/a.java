package i6;

import android.content.res.AssetManager;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AssetManager f6376b;

    public /* synthetic */ a(AssetManager assetManager, int i) {
        this.f6375a = i;
        this.f6376b = assetManager;
    }

    @Override // i6.s
    public final r a(x xVar) {
        switch (this.f6375a) {
        }
        return new b(this.f6376b, 0, this);
    }
}
