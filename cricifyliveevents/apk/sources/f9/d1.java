package f9;

import android.content.SharedPreferences;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f4066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ f1 f4069e;

    public d1(f1 f1Var, String str, boolean z10) {
        this.f4069e = f1Var;
        o8.u.d(str);
        this.f4065a = str;
        this.f4066b = z10;
    }

    public final boolean a() {
        if (!this.f4067c) {
            this.f4067c = true;
            this.f4068d = this.f4069e.q1().getBoolean(this.f4065a, this.f4066b);
        }
        return this.f4068d;
    }

    public final void b(boolean z10) {
        SharedPreferences.Editor editorEdit = this.f4069e.q1().edit();
        editorEdit.putBoolean(this.f4065a, z10);
        editorEdit.apply();
        this.f4068d = z10;
    }
}
