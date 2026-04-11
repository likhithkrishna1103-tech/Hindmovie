package fa;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.navigation.NavigationView;
import da.t;
import java.util.ArrayList;
import n.b0;
import o.l0;
import o.l2;
import o.o0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4525v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f4526w;

    public /* synthetic */ e(int i, Object obj) {
        this.f4525v = i;
        this.f4526w = obj;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        Activity activity;
        Rect rect;
        switch (this.f4525v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                NavigationView navigationView = (NavigationView) this.f4526w;
                int[] iArr = navigationView.G;
                navigationView.getLocationOnScreen(iArr);
                boolean z10 = true;
                boolean z11 = iArr[1] == 0;
                t tVar = navigationView.D;
                if (tVar.S != z11) {
                    tVar.S = z11;
                    int i = (tVar.f3630w.getChildCount() <= 0 && tVar.S) ? tVar.U : 0;
                    NavigationMenuView navigationMenuView = tVar.f3629v;
                    navigationMenuView.setPadding(0, i, 0, navigationMenuView.getPaddingBottom());
                }
                navigationView.setDrawTopInsetForeground(z11 && navigationView.J);
                boolean z12 = navigationView.getLayoutDirection() == 1;
                int i10 = iArr[0];
                navigationView.setDrawLeftInsetForeground((i10 == 0 || navigationView.getWidth() + i10 == 0) && (!z12 ? !navigationView.L : !navigationView.M));
                Context context = navigationView.getContext();
                while (true) {
                    if (!(context instanceof ContextWrapper)) {
                        activity = null;
                    } else if (context instanceof Activity) {
                        activity = (Activity) context;
                    } else {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                }
                if (activity != null) {
                    WindowManager windowManager = (WindowManager) activity.getSystemService("window");
                    if (Build.VERSION.SDK_INT >= 30) {
                        rect = windowManager.getCurrentWindowMetrics().getBounds();
                    } else {
                        Display defaultDisplay = windowManager.getDefaultDisplay();
                        Point point = new Point();
                        defaultDisplay.getRealSize(point);
                        rect = new Rect();
                        rect.right = point.x;
                        rect.bottom = point.y;
                    }
                    navigationView.setDrawBottomInsetForeground((rect.height() - navigationView.getHeight() == iArr[1]) && (Color.alpha(activity.getWindow().getNavigationBarColor()) != 0) && navigationView.K);
                    if ((rect.width() != iArr[0] && rect.width() - navigationView.getWidth() != iArr[0]) || (!z12 ? !navigationView.M : !navigationView.L)) {
                        z10 = false;
                    }
                    navigationView.setDrawRightInsetForeground(z10);
                }
                break;
            case 1:
                n.e eVar = (n.e) this.f4526w;
                ArrayList arrayList = eVar.C;
                if (eVar.a() && arrayList.size() > 0) {
                    int i11 = 0;
                    if (!((n.d) arrayList.get(0)).f8499a.T) {
                        View view = eVar.J;
                        if (view != null && view.isShown()) {
                            int size = arrayList.size();
                            while (i11 < size) {
                                Object obj = arrayList.get(i11);
                                i11++;
                                ((n.d) obj).f8499a.d();
                            }
                        } else {
                            eVar.dismiss();
                        }
                    }
                    break;
                }
                break;
            case 2:
                b0 b0Var = (b0) this.f4526w;
                l2 l2Var = b0Var.C;
                if (b0Var.a() && !l2Var.T) {
                    View view2 = b0Var.H;
                    if (view2 != null && view2.isShown()) {
                        l2Var.d();
                    } else {
                        b0Var.dismiss();
                    }
                    break;
                }
                break;
            case 3:
                o0 o0Var = (o0) this.f4526w;
                if (!o0Var.getInternalPopup().a()) {
                    o0Var.A.l(o0Var.getTextDirection(), o0Var.getTextAlignment());
                }
                ViewTreeObserver viewTreeObserver = o0Var.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                }
                break;
            default:
                l0 l0Var = (l0) this.f4526w;
                o0 o0Var2 = l0Var.f9261c0;
                l0Var.getClass();
                if (o0Var2.isAttachedToWindow() && o0Var2.getGlobalVisibleRect(l0Var.f9259a0)) {
                    l0Var.s();
                    l0Var.d();
                } else {
                    l0Var.dismiss();
                }
                break;
        }
    }
}
