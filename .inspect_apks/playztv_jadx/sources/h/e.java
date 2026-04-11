package h;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;
import cc.q0;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public final int A;
    public final int B;
    public final int C;
    public final boolean D;
    public final q0 E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f5462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Window f5463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CharSequence f5464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f5465e;
    public AlertController$RecycleListView f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f5466g;
    public Button i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CharSequence f5468j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Message f5469k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Button f5470l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CharSequence f5471m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Message f5472n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Button f5473o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f5474p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Message f5475q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public NestedScrollView f5476r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Drawable f5477s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ImageView f5478t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public TextView f5479u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public TextView f5480v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f5481w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ListAdapter f5482x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f5484z;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5467h = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f5483y = -1;
    public final com.google.android.material.datepicker.l F = new com.google.android.material.datepicker.l(2, this);

    public e(Context context, g gVar, Window window) {
        this.f5461a = context;
        this.f5462b = gVar;
        this.f5463c = window;
        q0 q0Var = new q0();
        q0Var.f2702b = new WeakReference(gVar);
        this.E = q0Var;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, g.j.AlertDialog, g.a.alertDialogStyle, 0);
        this.f5484z = typedArrayObtainStyledAttributes.getResourceId(g.j.AlertDialog_android_layout, 0);
        typedArrayObtainStyledAttributes.getResourceId(g.j.AlertDialog_buttonPanelSideLayout, 0);
        this.A = typedArrayObtainStyledAttributes.getResourceId(g.j.AlertDialog_listLayout, 0);
        typedArrayObtainStyledAttributes.getResourceId(g.j.AlertDialog_multiChoiceItemLayout, 0);
        this.B = typedArrayObtainStyledAttributes.getResourceId(g.j.AlertDialog_singleChoiceItemLayout, 0);
        this.C = typedArrayObtainStyledAttributes.getResourceId(g.j.AlertDialog_listItemLayout, 0);
        this.D = typedArrayObtainStyledAttributes.getBoolean(g.j.AlertDialog_showTitle, true);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(g.j.AlertDialog_buttonIconDimen, 0);
        typedArrayObtainStyledAttributes.recycle();
        gVar.e().h(1);
    }

    public static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static ViewGroup b(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public final void c(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        Message messageObtainMessage = onClickListener != null ? this.E.obtainMessage(i, onClickListener) : null;
        if (i == -3) {
            this.f5474p = charSequence;
            this.f5475q = messageObtainMessage;
        } else if (i == -2) {
            this.f5471m = charSequence;
            this.f5472n = messageObtainMessage;
        } else {
            if (i != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f5468j = charSequence;
            this.f5469k = messageObtainMessage;
        }
    }
}
