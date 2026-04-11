package pa;

import android.text.Editable;
import da.c0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends c0 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ p f10083v;

    public m(p pVar) {
        this.f10083v = pVar;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.f10083v.b().a();
    }

    @Override // da.c0, android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i10, int i11) {
        this.f10083v.b().b();
    }
}
