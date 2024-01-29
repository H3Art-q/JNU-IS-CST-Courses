\PassOptionsToPackage{AutoFakeBold}{xeCJK}
\LoadClass{article}
\usepackage{ctex}
\usepackage{amsmath}
\usepackage{fontspec}
\usepackage{amsmath}
\usepackage{amssymb}
\usepackage{amsfonts}
\usepackage{stackrel}
\usepackage{float}

\usepackage{geometry}
\geometry{left=3.18cm,right=3.18cm,top=4.04cm,bottom=2.54cm,headsep=1cm,headheight=35pt}
\usepackage{fontspec}
\usepackage{makecell}
\usepackage{fancyhdr}
\usepackage{adjustbox}
\usepackage{anyfontsize}

\usepackage[normalem]{ulem}
\useunder{\uline}{\ul}{}

\usepackage{graphicx}
\usepackage{indentfirst}
\setlength{\parindent}{0em} %首行缩进零个字符

\usepackage{setspace}

% Suppress FandolSong warning
\usepackage{xpatch}
\ExplSyntaxOn
\xpatchcmd \fontspec_new_script:nn
  { \__fontspec_warning:nxx }
  { \__fontspec_info:nxx }
  {}{}
% redeclare
\newfontscript{CJK}{hani}
% \newfontscript{CJK~Ideographic}{hani}
\ExplSyntaxOff

\usepackage{xcolor}
\definecolor{deepblue}{rgb}{0,0,0.5}
\definecolor{deepred}{rgb}{0.6,0,0}
\definecolor{deepgreen}{rgb}{0,0.5,0}

\usepackage{graphics, listings}
\lstset{
    basicstyle=\small\ttfamily,
    keywordstyle=\color{deepblue}\textbf,
    stringstyle=\color{deepred},
    breaklines=true,
    commentstyle=\color{deepgreen},
    numbers=left, numbersep=1em, frame=single
}

\newlength\widest
\makeatletter
\makeatother

\makeatletter

\def\course#1{\gdef\@course{#1}}
\def\@course{\@latex@warning@no@line{No \noexpand\course given}}

\def\expno#1{\gdef\@expno{#1}}
\def\@expno{\@latex@warning@no@line{No \noexpand\expno given}}

\def\exptype#1{\gdef\@exptype{#1}}

\def\authorno#1{\gdef\@authorno{#1}}
\def\@authorno{\@latex@warning@no@line{No \noexpand\authorno given}}

\def\director#1{\gdef\@director{#1}}
\def\@director{\@latex@warning@no@line{No \noexpand\director given}}

\def\classroom#1{\gdef\@classroom{#1}}
\def\@classroom{\@latex@warning@no@line{No \noexpand\classroom given}}

\def\college#1{\gdef\@college{#1}}
\def\@college{\@latex@warning@no@line{No \noexpand\college given}}

\def\department#1{\gdef\@department{#1}}
\def\@department{\@latex@warning@no@line{No \noexpand\department given}}

\def\major#1{\gdef\@major{#1}}
\def\@major{\@latex@warning@no@line{No \noexpand\major given}}

\def\yyyy#1{\gdef\@yyyy{#1}}
\def\mm#1{\gdef\@mm{#1}}
\def\dd#1{\gdef\@dd{#1}}
\def\timestart#1{\gdef\@timestart{#1}}
\def\timeend#1{\gdef\@timeend{#1}}


% 设置章节编号
\renewcommand\thesection{\chinese{section}、}
\renewcommand\thesubsection{\arabic{subsection}.}
\renewcommand\thesubsubsection{\alph{subsubsection})}

% 设置章节编号与章节标题的距离
\makeatletter
\renewcommand\@seccntformat[1]{%
    {\csname the#1\endcsname}
}

\makeatother
\pagestyle{fancy}
\fancyhead{}
\fancyhead[C]{{\bfseries \kaishu \fontsize{22pt}{\baselineskip}\selectfont 暨南大学本科实验报告专用纸 }(附页) \\  }
\fancyfoot[C]{\thepage}

\makeatletter
\renewcommand\maketitle{
    \begingroup
    \thispagestyle{empty}
    \vspace*{-2cm}
    \begin{center}
        \fontsize{22pt}{\baselineskip}\selectfont \kaishu \bfseries 暨南大学本科实验报告专用纸
    \end{center}
    \vspace*{-0.3cm}
    \begin{table}[htbp]
        \kaishu
        \fontsize{14pt}{\baselineskip}\selectfont

        \adjustbox{center}{
            \begin{tabular}{l p{6.9cm}<{\centering} l p{3.6cm}}
                课程名称 & \@course & 成绩评定 & 
                \\ \cline{2-2} \cline{4-4}
            \end{tabular}
        }

        \adjustbox{center}{
            \begin{tabular}{l p{6cm}<{\centering} l p{3.6cm}<{\centering}}
                实验项目名称 & \@title & 指导老师 & \@director
                \\ \cline{2-2} \cline{4-4}
            \end{tabular}
        }

        \adjustbox{center}{
            \begin{tabular}{l p{1.2cm}<{\centering} l p{3cm}<{\centering} l p{1.6cm}<{\centering}}
                实验项目编号 & \@expno & 实验项目类型 & \@exptype  & 实验地点 & \@classroom
                \\ \cline{2-2} \cline{4-4} \cline{6-6}
            \end{tabular}
        }

        \adjustbox{center}{
            \begin{tabular}{l p{4.2cm}<{\centering} l p{7.3cm}<{\centering}}
                学生姓名 & \@author & 学号 & \@authorno
                \\ \cline{2-2} \cline{4-4}
            \end{tabular}
        }
        
        \adjustbox{center}{
            \begin{tabular}{l p{4.15cm}<{\centering} l p{2.6cm}<{\centering} l p{4.4cm}<{\centering}}
                学院 & \@college & 系 & \@department & 专业   & \@major 
                \\ \cline{2-2} \cline{4-4} \cline{6-6} 
            \end{tabular}
        }

        \adjustbox{center}{
            \begin{tabular}{l p{0.8cm}<{\centering} l p{0.5cm}<{\centering} l p{0.5cm}<{\centering} l p{1cm}<{\centering} l p{1cm}<{\centering} lp{2.5cm}}
                实验时间 & \@yyyy & 年 & \@mm & 月 & \@dd & 日上午 & \@timestart & $\sim$ & \@timeend & \space &
                \\ \cline{2-2} \cline{4-4} \cline{6-6} \cline{8-8} \cline{10-10}
            \end{tabular}
        }

    \end{table}
    \endgroup
}

\makeatother
