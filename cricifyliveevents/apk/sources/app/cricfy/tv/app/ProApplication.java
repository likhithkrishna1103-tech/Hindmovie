package app.cricfy.tv.app;

import ab.g;
import android.app.Application;
import androidx.fragment.app.f1;
import androidx.recyclerview.widget.RecyclerView;
import app.cricfy.tv.activities.LandscapeActivity;
import h.j;
import java.util.ArrayList;
import java.util.List;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class ProApplication extends Application {
    public static ProApplication K;
    public List A;
    public ArrayList B;
    public ArrayList C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I;
    public int J;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public j f1568v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public LandscapeActivity f1569w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public f1 f1570x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public d f1571y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public List f1572z;

    public final void a(RecyclerView recyclerView) {
        if (this.J < 0) {
            return;
        }
        recyclerView.setClipToPadding(false);
        recyclerView.setPadding(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getPaddingRight(), this.J);
    }

    @Override // android.app.Application
    public final void onCreate() {
        super.onCreate();
        K = this;
        g.f(getApplicationContext());
    }
}
