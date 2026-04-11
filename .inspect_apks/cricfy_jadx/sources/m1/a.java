package m1;

import android.text.Editable;
import androidx.emoji2.text.b0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends Editable.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f8018a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f8019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class f8020c;

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence charSequence) {
        Class cls = f8020c;
        return cls != null ? new b0(cls, charSequence) : super.newEditable(charSequence);
    }
}
