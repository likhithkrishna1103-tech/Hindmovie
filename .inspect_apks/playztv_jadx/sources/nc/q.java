package nc;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.playz.tv.app.ProApplication;
import java.util.HashSet;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class q extends androidx.fragment.app.v {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public kc.b f8963r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public ProApplication f8964s0;

    public static HashSet P(int i, int i10) {
        Random random = new Random();
        HashSet hashSet = new HashSet();
        while (hashSet.size() < Math.min(i, i10)) {
            hashSet.add(Integer.valueOf(random.nextInt(i)));
        }
        return hashSet;
    }

    @Override // androidx.fragment.app.v
    public final void D() {
        this.f8964s0 = ProApplication.I;
        Q();
    }

    public final void Q() {
        ((TextView) this.f8963r0.f7620v).setVisibility(8);
        ((RecyclerView) this.f8963r0.f7622x).setVisibility(8);
        ((ProgressBar) this.f8963r0.f7621w).setVisibility(0);
        new Handler(Looper.getMainLooper()).postDelayed(new b(2, this), 1000L);
    }

    @Override // androidx.fragment.app.v
    public final View w(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(gc.k.fragment_more, (ViewGroup) null, false);
        int i = gc.j.not_available;
        TextView textView = (TextView) z7.a.k(viewInflate, i);
        if (textView != null) {
            i = gc.j.progress;
            ProgressBar progressBar = (ProgressBar) z7.a.k(viewInflate, i);
            if (progressBar != null) {
                i = gc.j.recycler_view;
                RecyclerView recyclerView = (RecyclerView) z7.a.k(viewInflate, i);
                if (recyclerView != null) {
                    LinearLayout linearLayout = (LinearLayout) viewInflate;
                    this.f8963r0 = new kc.b(linearLayout, textView, progressBar, recyclerView);
                    return linearLayout;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
