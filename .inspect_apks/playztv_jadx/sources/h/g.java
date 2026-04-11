package h;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;
import java.util.WeakHashMap;
import n.x1;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends d0 implements DialogInterface {
    public final e A;

    public g(ContextThemeWrapper contextThemeWrapper, int i) {
        super(contextThemeWrapper, h(contextThemeWrapper, i));
        this.A = new e(getContext(), this, getWindow());
    }

    public static int h(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(g.a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // h.d0, c.n, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        int i;
        ListAdapter listAdapter;
        View viewFindViewById;
        super.onCreate(bundle);
        e eVar = this.A;
        eVar.f5462b.setContentView(eVar.f5484z);
        Context context = eVar.f5461a;
        Window window = eVar.f5463c;
        View viewFindViewById2 = window.findViewById(g.f.parentPanel);
        View viewFindViewById3 = viewFindViewById2.findViewById(g.f.topPanel);
        View viewFindViewById4 = viewFindViewById2.findViewById(g.f.contentPanel);
        View viewFindViewById5 = viewFindViewById2.findViewById(g.f.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById2.findViewById(g.f.customPanel);
        View view = eVar.f5466g;
        if (view == null) {
            view = null;
        }
        boolean z2 = view != null;
        if (!z2 || !e.a(view)) {
            window.setFlags(131072, 131072);
        }
        if (z2) {
            FrameLayout frameLayout = (FrameLayout) window.findViewById(g.f.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (eVar.f5467h) {
                frameLayout.setPadding(0, 0, 0, 0);
            }
            if (eVar.f != null) {
                ((LinearLayout.LayoutParams) ((x1) viewGroup.getLayoutParams())).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View viewFindViewById6 = viewGroup.findViewById(g.f.topPanel);
        View viewFindViewById7 = viewGroup.findViewById(g.f.contentPanel);
        View viewFindViewById8 = viewGroup.findViewById(g.f.buttonPanel);
        ViewGroup viewGroupB = e.b(viewFindViewById6, viewFindViewById3);
        ViewGroup viewGroupB2 = e.b(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupB3 = e.b(viewFindViewById8, viewFindViewById5);
        NestedScrollView nestedScrollView = (NestedScrollView) window.findViewById(g.f.scrollView);
        eVar.f5476r = nestedScrollView;
        nestedScrollView.setFocusable(false);
        eVar.f5476r.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroupB2.findViewById(R.id.message);
        eVar.f5480v = textView;
        if (textView != null) {
            String str = eVar.f5465e;
            if (str != null) {
                textView.setText(str);
            } else {
                textView.setVisibility(8);
                eVar.f5476r.removeView(eVar.f5480v);
                if (eVar.f != null) {
                    ViewGroup viewGroup2 = (ViewGroup) eVar.f5476r.getParent();
                    int iIndexOfChild = viewGroup2.indexOfChild(eVar.f5476r);
                    viewGroup2.removeViewAt(iIndexOfChild);
                    viewGroup2.addView(eVar.f, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    viewGroupB2.setVisibility(8);
                }
            }
        }
        Button button = (Button) viewGroupB3.findViewById(R.id.button1);
        eVar.i = button;
        com.google.android.material.datepicker.l lVar = eVar.F;
        button.setOnClickListener(lVar);
        if (TextUtils.isEmpty(eVar.f5468j)) {
            eVar.i.setVisibility(8);
            i = 0;
        } else {
            eVar.i.setText(eVar.f5468j);
            eVar.i.setVisibility(0);
            i = 1;
        }
        Button button2 = (Button) viewGroupB3.findViewById(R.id.button2);
        eVar.f5470l = button2;
        button2.setOnClickListener(lVar);
        if (TextUtils.isEmpty(eVar.f5471m)) {
            eVar.f5470l.setVisibility(8);
        } else {
            eVar.f5470l.setText(eVar.f5471m);
            eVar.f5470l.setVisibility(0);
            i |= 2;
        }
        Button button3 = (Button) viewGroupB3.findViewById(R.id.button3);
        eVar.f5473o = button3;
        button3.setOnClickListener(lVar);
        if (TextUtils.isEmpty(eVar.f5474p)) {
            eVar.f5473o.setVisibility(8);
        } else {
            eVar.f5473o.setText(eVar.f5474p);
            eVar.f5473o.setVisibility(0);
            i |= 4;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(g.a.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            if (i == 1) {
                Button button4 = eVar.i;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button4.getLayoutParams();
                layoutParams.gravity = 1;
                layoutParams.weight = 0.5f;
                button4.setLayoutParams(layoutParams);
            } else if (i == 2) {
                Button button5 = eVar.f5470l;
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button5.getLayoutParams();
                layoutParams2.gravity = 1;
                layoutParams2.weight = 0.5f;
                button5.setLayoutParams(layoutParams2);
            } else if (i == 4) {
                Button button6 = eVar.f5473o;
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) button6.getLayoutParams();
                layoutParams3.gravity = 1;
                layoutParams3.weight = 0.5f;
                button6.setLayoutParams(layoutParams3);
            }
        }
        if (i == 0) {
            viewGroupB3.setVisibility(8);
        }
        if (eVar.f5481w != null) {
            viewGroupB.addView(eVar.f5481w, 0, new ViewGroup.LayoutParams(-1, -2));
            window.findViewById(g.f.title_template).setVisibility(8);
        } else {
            eVar.f5478t = (ImageView) window.findViewById(R.id.icon);
            if (TextUtils.isEmpty(eVar.f5464d) || !eVar.D) {
                window.findViewById(g.f.title_template).setVisibility(8);
                eVar.f5478t.setVisibility(8);
                viewGroupB.setVisibility(8);
            } else {
                TextView textView2 = (TextView) window.findViewById(g.f.alertTitle);
                eVar.f5479u = textView2;
                textView2.setText(eVar.f5464d);
                Drawable drawable = eVar.f5477s;
                if (drawable != null) {
                    eVar.f5478t.setImageDrawable(drawable);
                } else {
                    eVar.f5479u.setPadding(eVar.f5478t.getPaddingLeft(), eVar.f5478t.getPaddingTop(), eVar.f5478t.getPaddingRight(), eVar.f5478t.getPaddingBottom());
                    eVar.f5478t.setVisibility(8);
                }
            }
        }
        boolean z10 = viewGroup.getVisibility() != 8;
        int i10 = (viewGroupB == null || viewGroupB.getVisibility() == 8) ? 0 : 1;
        boolean z11 = viewGroupB3.getVisibility() != 8;
        if (!z11 && (viewFindViewById = viewGroupB2.findViewById(g.f.textSpacerNoButtons)) != null) {
            viewFindViewById.setVisibility(0);
        }
        if (i10 != 0) {
            NestedScrollView nestedScrollView2 = eVar.f5476r;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            View viewFindViewById9 = (eVar.f5465e == null && eVar.f == null) ? null : viewGroupB.findViewById(g.f.titleDividerNoCustom);
            if (viewFindViewById9 != null) {
                viewFindViewById9.setVisibility(0);
            }
        } else {
            View viewFindViewById10 = viewGroupB2.findViewById(g.f.textSpacerNoTitle);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        }
        AlertController$RecycleListView alertController$RecycleListView = eVar.f;
        if (alertController$RecycleListView != null) {
            alertController$RecycleListView.getClass();
            if (!z11 || i10 == 0) {
                alertController$RecycleListView.setPadding(alertController$RecycleListView.getPaddingLeft(), i10 != 0 ? alertController$RecycleListView.getPaddingTop() : alertController$RecycleListView.f856u, alertController$RecycleListView.getPaddingRight(), z11 ? alertController$RecycleListView.getPaddingBottom() : alertController$RecycleListView.f857v);
            }
        }
        if (!z10) {
            View view2 = eVar.f;
            if (view2 == null) {
                view2 = eVar.f5476r;
            }
            if (view2 != null) {
                int i11 = z11 ? 2 : 0;
                View viewFindViewById11 = window.findViewById(g.f.scrollIndicatorUp);
                View viewFindViewById12 = window.findViewById(g.f.scrollIndicatorDown);
                WeakHashMap weakHashMap = o0.f10475a;
                q0.g0.b(view2, i10 | i11, 3);
                if (viewFindViewById11 != null) {
                    viewGroupB2.removeView(viewFindViewById11);
                }
                if (viewFindViewById12 != null) {
                    viewGroupB2.removeView(viewFindViewById12);
                }
            }
        }
        AlertController$RecycleListView alertController$RecycleListView2 = eVar.f;
        if (alertController$RecycleListView2 == null || (listAdapter = eVar.f5482x) == null) {
            return;
        }
        alertController$RecycleListView2.setAdapter(listAdapter);
        int i12 = eVar.f5483y;
        if (i12 > -1) {
            alertController$RecycleListView2.setItemChecked(i12, true);
            alertController$RecycleListView2.setSelection(i12);
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A.f5476r;
        if (nestedScrollView == null || !nestedScrollView.i(keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A.f5476r;
        if (nestedScrollView == null || !nestedScrollView.i(keyEvent)) {
            return super.onKeyUp(i, keyEvent);
        }
        return true;
    }

    @Override // h.d0, android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        e eVar = this.A;
        eVar.f5464d = charSequence;
        TextView textView = eVar.f5479u;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
