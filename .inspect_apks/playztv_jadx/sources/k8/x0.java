package k8;

import android.content.SharedPreferences;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f7535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f7537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ z0 f7538e;

    public x0(z0 z0Var, String str, boolean z2) {
        this.f7538e = z0Var;
        t7.v.d(str);
        this.f7534a = str;
        this.f7535b = z2;
    }

    public final void a(boolean z2) {
        SharedPreferences.Editor editorEdit = this.f7538e.x1().edit();
        editorEdit.putBoolean(this.f7534a, z2);
        editorEdit.apply();
        this.f7537d = z2;
    }

    public final boolean b() {
        if (!this.f7536c) {
            this.f7536c = true;
            this.f7537d = this.f7538e.x1().getBoolean(this.f7534a, this.f7535b);
        }
        return this.f7537d;
    }
}
