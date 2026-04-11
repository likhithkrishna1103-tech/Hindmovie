package g1;

import android.widget.EditText;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h extends androidx.emoji2.text.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f4840a;

    public h(EditText editText) {
        this.f4840a = new WeakReference(editText);
    }

    @Override // androidx.emoji2.text.j
    public final void a() {
        i.a((EditText) this.f4840a.get(), 1);
    }
}
