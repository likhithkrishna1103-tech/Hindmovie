package k8;

import android.content.SharedPreferences;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k2 implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ g2 f7288a;

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        g2 g2Var = this.f7288a;
        g2Var.getClass();
        if ("IABTCF_TCString".equals(str)) {
            g2Var.g().I.d("IABTCF_TCString change picked up in listener.");
            m2 m2Var = g2Var.P;
            t7.v.h(m2Var);
            m2Var.b(500L);
        }
    }
}
