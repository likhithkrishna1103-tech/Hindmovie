package o;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import androidx.appcompat.widget.SearchView;
import androidx.media3.decoder.DecoderInputBuffer;
import app.cricfy.tv.activities.MainActivity;
import app.cricfy.tv.activities.TvActivity;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s2 implements TextWatcher {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f9348v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ KeyEvent.Callback f9349w;

    public /* synthetic */ s2(KeyEvent.Callback callback, int i) {
        this.f9348v = i;
        this.f9349w = callback;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        int i = this.f9348v;
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i10, int i11) {
        int i12 = this.f9348v;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i10, int i11) {
        int i12 = this.f9348v;
        KeyEvent.Callback callback = this.f9349w;
        switch (i12) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                SearchView searchView = (SearchView) callback;
                Editable text = searchView.K.getText();
                searchView.f575v0 = text;
                boolean zIsEmpty = TextUtils.isEmpty(text);
                searchView.v(!zIsEmpty);
                if (searchView.f573t0 && !searchView.f567m0 && zIsEmpty) {
                    searchView.P.setVisibility(8);
                } else {
                    i = 8;
                }
                searchView.R.setVisibility(i);
                searchView.r();
                searchView.u();
                if (searchView.f563i0 != null && !TextUtils.equals(charSequence, searchView.f574u0)) {
                    MainActivity.w((MainActivity) ((m2.e) searchView.f563i0).f8050v, charSequence.toString());
                }
                searchView.f574u0 = charSequence.toString();
                break;
            case 1:
                TvActivity tvActivity = (TvActivity) callback;
                String string = charSequence.toString();
                if (string != null) {
                    int i13 = TvActivity.f1550s0;
                    tvActivity.f1566q0 = string.isEmpty() ? 0 : 2;
                    x5.r rVar = tvActivity.f1558h0;
                    if (rVar != null) {
                        rVar.T(string);
                    } else if (!tvActivity.f1565p0) {
                        tvActivity.f1551a0.U(string);
                    } else {
                        tvActivity.f1556f0.U(string);
                    }
                } else {
                    tvActivity.f1566q0 = 0;
                }
                break;
            default:
                TextInputLayout textInputLayout = (TextInputLayout) callback;
                if (charSequence.length() != 0) {
                    textInputLayout.setEndIconDrawable(q5.j.close_24px);
                    textInputLayout.setEndIconContentDescription("Clear");
                } else {
                    textInputLayout.setEndIconDrawable(g.e.abc_ic_menu_paste_mtrl_am_alpha);
                    textInputLayout.setEndIconContentDescription("Paste");
                }
                break;
        }
    }

    public s2(v5.m mVar, TextInputLayout textInputLayout) {
        this.f9348v = 2;
        this.f9349w = textInputLayout;
    }

    private final void a(Editable editable) {
    }

    private final void b(Editable editable) {
    }

    private final void c(Editable editable) {
    }

    private final void d(int i, int i10, int i11, CharSequence charSequence) {
    }

    private final void e(int i, int i10, int i11, CharSequence charSequence) {
    }

    private final void f(int i, int i10, int i11, CharSequence charSequence) {
    }
}
