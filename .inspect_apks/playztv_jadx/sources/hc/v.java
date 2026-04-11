package hc;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import androidx.appcompat.widget.SearchView;
import androidx.media3.decoder.DecoderInputBuffer;
import com.playz.tv.activities.MainActivity;
import com.playz.tv.activities.TvActivity;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v implements TextWatcher {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f6065u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f6066v;

    public /* synthetic */ v(int i, Object obj) {
        this.f6065u = i;
        this.f6066v = obj;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        int i = this.f6065u;
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i10, int i11) {
        int i12 = this.f6065u;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i10, int i11) {
        int i12 = this.f6065u;
        Object obj = this.f6066v;
        switch (i12) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                TvActivity tvActivity = (TvActivity) obj;
                String string = charSequence.toString();
                if (string != null) {
                    int i13 = TvActivity.f3654x0;
                    tvActivity.f3675v0 = string.isEmpty() ? 0 : 2;
                    nc.u uVar = tvActivity.f3663i0;
                    if (uVar != null) {
                        uVar.R(string);
                    } else if (!tvActivity.f3674u0) {
                        tvActivity.Z.S(string);
                    } else {
                        tvActivity.f3660f0.S(string);
                    }
                } else {
                    tvActivity.f3675v0 = 0;
                }
                break;
            case 1:
                ((lc.d) obj).getFilter().filter(charSequence);
                break;
            default:
                SearchView searchView = (SearchView) obj;
                Editable text = searchView.J.getText();
                searchView.f918u0 = text;
                boolean zIsEmpty = TextUtils.isEmpty(text);
                searchView.v(!zIsEmpty);
                if (searchView.f916s0 && !searchView.l0 && zIsEmpty) {
                    searchView.O.setVisibility(8);
                } else {
                    i = 8;
                }
                searchView.Q.setVisibility(i);
                searchView.r();
                searchView.u();
                if (searchView.f906h0 != null && !TextUtils.equals(charSequence, searchView.f917t0)) {
                    MainActivity.w((MainActivity) ((u5.c) searchView.f906h0).f12782v, charSequence.toString());
                }
                searchView.f917t0 = charSequence.toString();
                break;
        }
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
