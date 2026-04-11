package v9;

import android.text.Editable;
import j9.d0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k extends d0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ m f13368u;

    public k(m mVar) {
        this.f13368u = mVar;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.f13368u.b().a();
    }

    @Override // j9.d0, android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i10, int i11) {
        this.f13368u.b().b();
    }
}
