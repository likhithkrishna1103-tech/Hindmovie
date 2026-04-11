package g1;

import android.text.Editable;
import androidx.emoji2.text.x;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends Editable.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f4825a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f4826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class f4827c;

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence charSequence) {
        Class cls = f4827c;
        return cls != null ? new x(cls, charSequence) : super.newEditable(charSequence);
    }
}
