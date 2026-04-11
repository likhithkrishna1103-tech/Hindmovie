package d7;

import android.content.res.AssetManager;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AssetManager f3447b;

    public /* synthetic */ a(AssetManager assetManager, int i) {
        this.f3446a = i;
        this.f3447b = assetManager;
    }

    @Override // d7.u
    public final t a(a0 a0Var) {
        switch (this.f3446a) {
        }
        return new b(0, this.f3447b, this);
    }
}
