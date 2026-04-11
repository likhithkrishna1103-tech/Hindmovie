package f1;

import android.content.SharedPreferences;
import ge.i;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f3927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f3928b;

    public f(SharedPreferences sharedPreferences, Set set) {
        i.e(sharedPreferences, "prefs");
        this.f3927a = sharedPreferences;
        this.f3928b = set;
    }
}
