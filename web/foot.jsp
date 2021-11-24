<%-- 
    Document   : foot
    Created on : 15/10/2021, 01:11:49 PM
    Author     : kcordon
--%>



<!--           Dashboard Counts Section
          <section class="pb-0">
            <div class="container-fluid">
              <div class="card mb-0">
                <div class="card-body">
                  <div class="row gx-5 bg-white">
                     Item 
                    <div class="col-xl-3 col-sm-6 py-4 border-lg-end border-gray-200">
                      <div class="d-flex align-items-center">
                        <div class="icon flex-shrink-0 bg-violet">
                          <svg class="svg-icon svg-icon-sm svg-icon-heavy">
                            <use xlink:href="#user-1"> </use>
                          </svg>
                        </div>
                        <div class="mx-3">
                          <h6 class="h4 fw-light text-gray-600 mb-3">New<br>Clients</h6>
                          <div class="progress" style="height: 4px">
                            <div class="progress-bar bg-violet" role="progressbar" style="width: 25%; height: 4px;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                          </div>
                        </div>
                        <div class="number"><strong class="text-lg">25</strong></div>
                      </div>
                    </div>
                     Item 
                    <div class="col-xl-3 col-sm-6 py-4 border-lg-end border-gray-200">
                      <div class="d-flex align-items-center">
                        <div class="icon flex-shrink-0 bg-red">
                          <svg class="svg-icon svg-icon-sm svg-icon-heavy">
                            <use xlink:href="#survey-1"> </use>
                          </svg>
                        </div>
                        <div class="mx-3">
                          <h6 class="h4 fw-light text-gray-600 mb-3">Work<br>Orders</h6>
                          <div class="progress" style="height: 4px">
                            <div class="progress-bar bg-red" role="progressbar" style="width: 70%; height: 4px;" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100"></div>
                          </div>
                        </div>
                        <div class="number"><strong class="text-lg">70</strong></div>
                      </div>
                    </div>
                     Item 
                    <div class="col-xl-3 col-sm-6 py-4 border-lg-end border-gray-200">
                      <div class="d-flex align-items-center">
                        <div class="icon flex-shrink-0 bg-green">
                          <svg class="svg-icon svg-icon-sm svg-icon-heavy">
                            <use xlink:href="#numbers-1"> </use>
                          </svg>
                        </div>
                        <div class="mx-3">
                          <h6 class="h4 fw-light text-gray-600 mb-3">New<br>Invoices</h6>
                          <div class="progress" style="height: 4px">
                            <div class="progress-bar bg-green" role="progressbar" style="width: 40%; height: 4px;" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"></div>
                          </div>
                        </div>
                        <div class="number"><strong class="text-lg">40</strong></div>
                      </div>
                    </div>
                     Item 
                    <div class="col-xl-3 col-sm-6 py-4">
                      <div class="d-flex align-items-center">
                        <div class="icon flex-shrink-0 bg-orange">
                          <svg class="svg-icon svg-icon-sm svg-icon-heavy">
                            <use xlink:href="#list-details-1"> </use>
                          </svg>
                        </div>
                        <div class="mx-3">
                          <h6 class="h4 fw-light text-gray-600 mb-3">Open<br>Cases</h6>
                          <div class="progress" style="height: 4px">
                            <div class="progress-bar bg-orange" role="progressbar" style="width: 50%; height: 4px;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                          </div>
                        </div>
                        <div class="number"><strong class="text-lg">50</strong></div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </section>
           Dashboard Header Section    
          <section class="pb-0">
            <div class="container-fluid">
              <div class="row align-items-stretch">
                 Statistics 
                <div class="col-lg-3 col-12">
                  <div class="card mb-3">
                    <div class="card-body">
                      <div class="d-flex align-items-center">
                        <div class="icon flex-shrink-0 bg-red"><i class="fas fa-tasks"></i></div>
                        <div class="ms-3"><strong class="text-lg d-block lh-1 mb-1">234</strong><small class="text-uppercase text-gray-500 small d-block lh-1">Applications</small></div>
                      </div>
                    </div>
                  </div>
                  <div class="card mb-3">
                    <div class="card-body">
                      <div class="d-flex align-items-center">
                        <div class="icon flex-shrink-0 bg-green"><i class="far fa-calendar"></i></div>
                        <div class="ms-3"><strong class="text-lg d-block lh-1 mb-1">152</strong><small class="text-uppercase text-gray-500 small d-block lh-1">Interviews</small></div>
                      </div>
                    </div>
                  </div>
                  <div class="card mb-0">
                    <div class="card-body">
                      <div class="d-flex align-items-center">
                        <div class="icon flex-shrink-0 bg-orange"><i class="far fa-paper-plane"></i></div>
                        <div class="ms-3"><strong class="text-lg d-block lh-1 mb-1">147</strong><small class="text-uppercase text-gray-500 small d-block lh-1">Forwards</small></div>
                      </div>
                    </div>
                  </div>
                </div>
                 Line Chart            
                <div class="col-lg-6 col-12">
                  <div class="card mb-0 h-100">
                    <div class="card-body">
                      <canvas id="lineCahrt"></canvas>
                    </div>
                  </div>
                </div>
                <div class="col-lg-3 col-12">
                   Bar Chart   
                  <div class="card">
                    <div class="card-body"><strong class="h2 mb-0 d-block text-violet">95%</strong><small class="text-gray-500 small text-uppercase d-block mb-3">Current Server Uptime</small>
                      <canvas id="barChartHome"></canvas>
                    </div>
                  </div>
                   Numbers
                  <div class="card mb-0">
                    <div class="card-body">
                      <div class="d-flex align-items-center">
                        <div class="icon flex-shrink-0 bg-green"><i class="fas fa-chart-area"></i></div>
                        <div class="ms-3"><strong class="text-lg mb-0 d-block lh-1">99.9%</strong><small class="text-gray-500 small text-uppercase">Success Rate</small></div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </section>
           Projects Section
          <section class="pb-0">
            <div class="container-fluid">
               Project
              <div class="card mb-3">
                <div class="card-body p-3">
                  <div class="row align-items-center gx-lg-5 gy-3">
                    <div class="col-lg-6 border-lg-end">
                      <div class="d-flex align-items-center justify-content-between">
                        <div class="d-flex align-items-center"><img class="img-fluid shadow-sm" src="img/project-1.jpg" alt="..." width="50">
                          <div class="ms-3">
                            <h3 class="h4 text-gray-700 mb-0">Project Title</h3><small class="text-gray-500">Lorem Ipsum Dolor</small>
                          </div>
                        </div><span class="text-sm text-gray-600 d-none d-sm-block">Today at 4:24 AM</span>
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="d-flex align-items-center">
                        <p class="d-flex mb-0 text-gray-600 text-sm d-flex align-items-center flex-shrink-0"><i class="far fa-clock me-1"></i>12:00 PM</p>
                        <p class="d-flex mb-0 mx-3 text-gray-600 text-sm d-flex align-items-center flex-shrink-0"><i class="far fa-comment me-1"></i>20</p>
                        <div class="progress w-100" style="height: 5px; max-width: 15rem">
                          <div class="progress-bar bg-red" role="progressbar" style="width: 45%; height: 6px;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
               Project
              <div class="card mb-3">
                <div class="card-body p-3">
                  <div class="row align-items-center gx-lg-5 gy-3">
                    <div class="col-lg-6 border-lg-end">
                      <div class="d-flex align-items-center justify-content-between">
                        <div class="d-flex align-items-center"><img class="img-fluid shadow-sm" src="img/project-2.jpg" alt="..." width="50">
                          <div class="ms-3">
                            <h3 class="h4 text-gray-700 mb-0">Project Title</h3><small class="text-gray-500">Lorem Ipsum Dolor</small>
                          </div>
                        </div><span class="text-sm text-gray-600 d-none d-sm-block">Today at 4:24 AM</span>
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="d-flex align-items-center">
                        <p class="d-flex mb-0 text-gray-600 text-sm d-flex align-items-center flex-shrink-0"><i class="far fa-clock me-1"></i>12:00 PM</p>
                        <p class="d-flex mb-0 mx-3 text-gray-600 text-sm d-flex align-items-center flex-shrink-0"><i class="far fa-comment me-1"></i>20</p>
                        <div class="progress w-100" style="height: 5px; max-width: 15rem">
                          <div class="progress-bar bg-green" role="progressbar" style="width: 45%; height: 6px;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
               Project
              <div class="card mb-3">
                <div class="card-body p-3">
                  <div class="row align-items-center gx-lg-5 gy-3">
                    <div class="col-lg-6 border-lg-end">
                      <div class="d-flex align-items-center justify-content-between">
                        <div class="d-flex align-items-center"><img class="img-fluid shadow-sm" src="img/project-3.jpg" alt="..." width="50">
                          <div class="ms-3">
                            <h3 class="h4 text-gray-700 mb-0">Project Title</h3><small class="text-gray-500">Lorem Ipsum Dolor</small>
                          </div>
                        </div><span class="text-sm text-gray-600 d-none d-sm-block">Today at 4:24 AM</span>
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="d-flex align-items-center">
                        <p class="d-flex mb-0 text-gray-600 text-sm d-flex align-items-center flex-shrink-0"><i class="far fa-clock me-1"></i>12:00 PM</p>
                        <p class="d-flex mb-0 mx-3 text-gray-600 text-sm d-flex align-items-center flex-shrink-0"><i class="far fa-comment me-1"></i>20</p>
                        <div class="progress w-100" style="height: 5px; max-width: 15rem">
                          <div class="progress-bar bg-violet" role="progressbar" style="width: 45%; height: 6px;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
               Project
              <div class="card mb-0">
                <div class="card-body p-3">
                  <div class="row align-items-center gx-lg-5 gy-3">
                    <div class="col-lg-6 border-lg-end">
                      <div class="d-flex align-items-center justify-content-between">
                        <div class="d-flex align-items-center"><img class="img-fluid shadow-sm" src="img/project-4.jpg" alt="..." width="50">
                          <div class="ms-3">
                            <h3 class="h4 text-gray-700 mb-0">Project Title</h3><small class="text-gray-500">Lorem Ipsum Dolor</small>
                          </div>
                        </div><span class="text-sm text-gray-600 d-none d-sm-block">Today at 4:24 AM</span>
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="d-flex align-items-center">
                        <p class="d-flex mb-0 text-gray-600 text-sm d-flex align-items-center flex-shrink-0"><i class="far fa-clock me-1"></i>12:00 PM</p>
                        <p class="d-flex mb-0 mx-3 text-gray-600 text-sm d-flex align-items-center flex-shrink-0"><i class="far fa-comment me-1"></i>20</p>
                        <div class="progress w-100" style="height: 5px; max-width: 15rem">
                          <div class="progress-bar bg-orange" role="progressbar" style="width: 45%; height: 6px;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </section>
           Client Section
          <section class="pb-0">
            <div class="container-fluid">
              <div class="row gy-4">
                 Work Amount  
                <div class="col-lg-4">
                  <div class="card mb-0">
                    <div class="card-close">
                      <div class="dropdown">
                        <button class="dropdown-toggle text-sm" type="button" id="closeCard1" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-ellipsis-v"></i></button>
                        <div class="dropdown-menu dropdown-menu-end shadow-sm" aria-labelledby="closeCard1"><a class="dropdown-item py-1 px-3 remove" href="#"> <i class="fas fa-times"></i>Close</a><a class="dropdown-item py-1 px-3 edit" href="#"> <i class="fas fa-cog"></i>Edit</a></div>
                      </div>
                    </div>
                    <div class="card-body d-flex flex-column">
                      <h3 class="mb-1">Work Hours</h3><small class="text-gray-500 d-block mb-0">Lorem ipsum dolor sit amet.</small>
                      <div class="pie-with-centered-text text-center my-5">
                        <canvas class="z-index-20" id="pieChart"></canvas>
                        <div class="text"><strong class="d-block lh-1 text-lg">90</strong><span class="text-gray-500">Hours</span></div>
                      </div>
                    </div>
                  </div>
                </div>
                 Client Profile 
                <div class="col-lg-4">
                  <div class="card mb-0">
                    <div class="card-close">
                      <div class="dropdown">
                        <button class="dropdown-toggle text-sm" type="button" id="closeCard1" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-ellipsis-v"></i></button>
                        <div class="dropdown-menu dropdown-menu-end shadow-sm" aria-labelledby="closeCard1"><a class="dropdown-item py-1 px-3 remove" href="#"> <i class="fas fa-times"></i>Close</a><a class="dropdown-item py-1 px-3 edit" href="#"> <i class="fas fa-cog"></i>Edit</a></div>
                      </div>
                    </div>
                    <div class="card-body text-center">
                      <div class="client-avatar mb-3"><img class="img-fluid rounded-circle shadow-0" src="img/avatar-2.jpg" alt="...">
                        <div class="status bg-green"></div>
                      </div>
                      <h3 class="fw-normal">Jason Doe</h3>
                      <p class="text-sm text-gray-500 mb-1">Web Developer</p><a class="btn btn-faintGreen btn-sm text-white px-4 rounded-pill py-0" href="#">Follow</a>
                      <div class="row py-4 gy-3">
                        <div class="col-4"><strong class="d-block lh-1">20</strong><small>Photos</small></div>
                        <div class="col-4"><strong class="d-block lh-1">54</strong><small>Videos</small></div>
                        <div class="col-4"><strong class="d-block lh-1">235</strong><small>Tasks</small></div>
                      </div>
                      <div class="d-flex justify-content-between"><a class="text-gray-500 text-sm" href="#" target="_blank"><i class="fab fa-facebook-f"></i></a><a class="text-gray-500 text-sm" href="#" target="_blank"><i class="fab fa-twitter"></i></a><a class="text-gray-500 text-sm" href="#" target="_blank"><i class="fab fa-google"></i></a><a class="text-gray-500 text-sm" href="#" target="_blank"><i class="fab fa-instagram"></i></a><a class="text-gray-500 text-sm" href="#" target="_blank"><i class="fab fa-linkedin-in"></i></a>
                      </div>
                    </div>
                  </div>
                </div>
                 Total Overdue             
                <div class="col-lg-4">
                  <div class="card mb-0">
                    <div class="card-close">
                      <div class="dropdown">
                        <button class="dropdown-toggle text-sm" type="button" id="closeCard1" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-ellipsis-v"></i></button>
                        <div class="dropdown-menu dropdown-menu-end shadow-sm" aria-labelledby="closeCard1"><a class="dropdown-item py-1 px-3 remove" href="#"> <i class="fas fa-times"></i>Close</a><a class="dropdown-item py-1 px-3 edit" href="#"> <i class="fas fa-cog"></i>Edit</a></div>
                      </div>
                    </div>
                    <div class="card-body d-flex flex-column">
                      <h3>Total Overdue</h3>
                      <p class="small mb-5 text-gray-500">Lorem ipsum dolor sit amet.</p>
                      <p class="text-xl text-center fw-normal">$20,000</p>
                      <div class="chart mt-auto">
                        <canvas id="lineChart1">                               </canvas>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </section>
           Feeds Section
          <section class="pb-0">
            <div class="container-fluid">
              <div class="row gy-4">
                 Trending Articles
                <div class="col-lg-6">
                  <div class="card mb-0">
                    <div class="card-header position-relative">
                      <div class="card-close">
                        <div class="dropdown">
                          <button class="dropdown-toggle text-sm" type="button" id="closeCard1" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-ellipsis-v"></i></button>
                          <div class="dropdown-menu dropdown-menu-end shadow-sm" aria-labelledby="closeCard1"><a class="dropdown-item py-1 px-3 remove" href="#"> <i class="fas fa-times"></i>Close</a><a class="dropdown-item py-1 px-3 edit" href="#"> <i class="fas fa-cog"></i>Edit</a></div>
                        </div>
                      </div>
                      <h2 class="h3 mb-0 d-flex align-items-center">Trending Articles   <span class="badge rounded-pill bg-green ms-2 text-xs">4 New       </span></h2>
                    </div>
                    <div class="card-body p-0">
                      <div class="p-3 d-flex align-items-center"><img class="img-fluid rounded-circle p-1 border border-faintGreen flex-shrink-0" src="img/avatar-1.jpg" alt="..." width="50">
                        <div class="ms-3"><a class="d-block" href="#">
                            <h3 class="h5 fw-normal text-dark mb-0">Lorem Ipsum Dolor</h3></a><small class="text-gray-500">Posted on 5th June 2017 by Aria Smith.   </small></div>
                      </div>
                      <div class="p-3 d-flex align-items-center bg-light"><img class="img-fluid rounded-circle p-1 border border-faintGreen flex-shrink-0" src="img/avatar-2.jpg" alt="..." width="50">
                        <div class="ms-3"><a class="d-block" href="#">
                            <h3 class="h5 fw-normal text-dark mb-0">Lorem Ipsum Dolor</h3></a><small class="text-gray-500">Posted on 5th June 2017 by Frank Williams.   </small></div>
                      </div>
                      <div class="p-3 d-flex align-items-center"><img class="img-fluid rounded-circle p-1 border border-faintGreen flex-shrink-0" src="img/avatar-3.jpg" alt="..." width="50">
                        <div class="ms-3"><a class="d-block" href="#">
                            <h3 class="h5 fw-normal text-dark mb-0">Lorem Ipsum Dolor</h3></a><small class="text-gray-500">Posted on 5th June 2017 by Ashley Wood.   </small></div>
                      </div>
                      <div class="p-3 d-flex align-items-center bg-light"><img class="img-fluid rounded-circle p-1 border border-faintGreen flex-shrink-0" src="img/avatar-4.jpg" alt="..." width="50">
                        <div class="ms-3"><a class="d-block" href="#">
                            <h3 class="h5 fw-normal text-dark mb-0">Lorem Ipsum Dolor</h3></a><small class="text-gray-500">Posted on 5th June 2017 by Jason Doe.   </small></div>
                      </div>
                      <div class="p-3 d-flex align-items-center"><img class="img-fluid rounded-circle p-1 border border-faintGreen flex-shrink-0" src="img/avatar-5.jpg" alt="..." width="50">
                        <div class="ms-3"><a class="d-block" href="#">
                            <h3 class="h5 fw-normal text-dark mb-0">Lorem Ipsum Dolor</h3></a><small class="text-gray-500">Posted on 5th June 2017 by Sam Martinez.   </small></div>
                      </div>
                    </div>
                  </div>
                </div>
                 Check List 
                <div class="col-lg-6">
                  <div class="card rounded-0 mb-0">
                    <div class="card-header position-relative px-4">
                      <div class="card-close">
                        <div class="dropdown">
                          <button class="dropdown-toggle text-sm" type="button" id="closeCard1" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-ellipsis-v"></i></button>
                          <div class="dropdown-menu dropdown-menu-end shadow-sm" aria-labelledby="closeCard1"><a class="dropdown-item py-1 px-3 remove" href="#"> <i class="fas fa-times"></i>Close</a><a class="dropdown-item py-1 px-3 edit" href="#"> <i class="fas fa-cog"></i>Edit</a></div>
                        </div>
                      </div>
                      <h2 class="h3 mb-0">To Do List </h2>
                    </div>
                    <div class="card-body p-0">
                      <div class="p-3">
                        <div class="form-check mb-0 py-1">
                          <input class="form-check-input" type="checkbox" name="input-1" id="input-1" checked>
                          <label class="form-check-label text-gray-600 text-sm" for="input-1">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</label>
                        </div>
                      </div>
                      <div class="p-3 bg-light">
                        <div class="form-check mb-0 py-1">
                          <input class="form-check-input" type="checkbox" name="input-2" id="input-2" checked>
                          <label class="form-check-label text-gray-600 text-sm" for="input-2">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</label>
                        </div>
                      </div>
                      <div class="p-3">
                        <div class="form-check mb-0 py-1">
                          <input class="form-check-input" type="checkbox" name="input-3" id="input-3">
                          <label class="form-check-label text-gray-600 text-sm" for="input-3">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</label>
                        </div>
                      </div>
                      <div class="p-3 bg-light">
                        <div class="form-check mb-0 py-1">
                          <input class="form-check-input" type="checkbox" name="input-4" id="input-4">
                          <label class="form-check-label text-gray-600 text-sm" for="input-4">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</label>
                        </div>
                      </div>
                      <div class="p-3">
                        <div class="form-check mb-0 py-1">
                          <input class="form-check-input" type="checkbox" name="input-5" id="input-5">
                          <label class="form-check-label text-gray-600 text-sm" for="input-5">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</label>
                        </div>
                      </div>
                      <div class="p-3 bg-light">
                        <div class="form-check mb-0 py-1">
                          <input class="form-check-input" type="checkbox" name="input-6" id="input-6">
                          <label class="form-check-label text-gray-600 text-sm" for="input-6">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</label>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </section>
           Updates Section                                                
          <section>
            <div class="container-fluid">
              <div class="row gy-4">
                 Recent Updates
                <div class="col-lg-4">
                  <div class="card mb-0">
                    <div class="card-header position-relative px-4">
                      <div class="card-close">
                        <div class="dropdown">
                          <button class="dropdown-toggle text-sm" type="button" id="closeCard1" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-ellipsis-v"></i></button>
                          <div class="dropdown-menu dropdown-menu-end shadow-sm" aria-labelledby="closeCard1"><a class="dropdown-item py-1 px-3 remove" href="#"> <i class="fas fa-times"></i>Close</a><a class="dropdown-item py-1 px-3 edit" href="#"> <i class="fas fa-cog"></i>Edit</a></div>
                        </div>
                      </div>
                      <h3 class="h4 mb-0">Recent Updates</h3>
                    </div>
                    <div class="card-body p-0">
                       Item
                      <div class="p-3 d-flex justify-content-between">
                        <div class="d-flex"><i class="fas fa-rss text-gray-600"></i>
                          <div class="ms-3">
                            <h5 class="fw-normal text-gray-600 mb-1">Lorem ipsum dolor sit amet.</h5>
                            <p class="mb-0 text-xs text-gray-500">Lorem ipsum dolor sit amet, consectetur adipisicing elit sed.</p>
                          </div>
                        </div>
                        <div class="text-end ms-2"><strong class="d-block lh-1 h2 mb-0 text-gray-500">24</strong><small class="d-block lh-1 text-gray-500">May</small></div>
                      </div>
                       Item
                      <div class="p-3 d-flex justify-content-between bg-light">
                        <div class="d-flex"><i class="fas fa-rss text-gray-600"></i>
                          <div class="ms-3">
                            <h5 class="fw-normal text-gray-600 mb-1">Lorem ipsum dolor sit amet.</h5>
                            <p class="mb-0 text-xs text-gray-500">Lorem ipsum dolor sit amet, consectetur adipisicing elit sed.</p>
                          </div>
                        </div>
                        <div class="text-end ms-2"><strong class="d-block lh-1 h2 mb-0 text-gray-500">24</strong><small class="d-block lh-1 text-gray-500">May</small></div>
                      </div>
                       Item
                      <div class="p-3 d-flex justify-content-between">
                        <div class="d-flex"><i class="fas fa-rss text-gray-600"></i>
                          <div class="ms-3">
                            <h5 class="fw-normal text-gray-600 mb-1">Lorem ipsum dolor sit amet.</h5>
                            <p class="mb-0 text-xs text-gray-500">Lorem ipsum dolor sit amet, consectetur adipisicing elit sed.</p>
                          </div>
                        </div>
                        <div class="text-end ms-2"><strong class="d-block lh-1 h2 mb-0 text-gray-500">24</strong><small class="d-block lh-1 text-gray-500">May</small></div>
                      </div>
                       Item
                      <div class="p-3 d-flex justify-content-between bg-light">
                        <div class="d-flex"><i class="fas fa-rss text-gray-600"></i>
                          <div class="ms-3">
                            <h5 class="fw-normal text-gray-600 mb-1">Lorem ipsum dolor sit amet.</h5>
                            <p class="mb-0 text-xs text-gray-500">Lorem ipsum dolor sit amet, consectetur adipisicing elit sed.</p>
                          </div>
                        </div>
                        <div class="text-end ms-2"><strong class="d-block lh-1 h2 mb-0 text-gray-500">24</strong><small class="d-block lh-1 text-gray-500">May</small></div>
                      </div>
                       Item
                      <div class="p-3 d-flex justify-content-between">
                        <div class="d-flex"><i class="fas fa-rss text-gray-600"></i>
                          <div class="ms-3">
                            <h5 class="fw-normal text-gray-600 mb-1">Lorem ipsum dolor sit amet.</h5>
                            <p class="mb-0 text-xs text-gray-500">Lorem ipsum dolor sit amet, consectetur adipisicing elit sed.</p>
                          </div>
                        </div>
                        <div class="text-end ms-2"><strong class="d-block lh-1 h2 mb-0 text-gray-500">24</strong><small class="d-block lh-1 text-gray-500">May</small></div>
                      </div>
                    </div>
                  </div>
                </div>
                 Daily Feeds 
                <div class="col-lg-4">
                  <div class="card mb-0">
                    <div class="card-header position-relative">
                      <div class="card-close">
                        <div class="dropdown">
                          <button class="dropdown-toggle text-sm" type="button" id="closeCard1" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-ellipsis-v"></i></button>
                          <div class="dropdown-menu dropdown-menu-end shadow-sm" aria-labelledby="closeCard1"><a class="dropdown-item py-1 px-3 remove" href="#"> <i class="fas fa-times"></i>Close</a><a class="dropdown-item py-1 px-3 edit" href="#"> <i class="fas fa-cog"></i>Edit</a></div>
                        </div>
                      </div>
                      <h3 class="h4 mb-0">Daily Feeds</h3>
                    </div>
                    <div class="card-body p-0">
                       Item
                      <div class="p-3 border-bottom border-gray-200">
                        <div class="d-flex justify-content-between">
                          <div class="d-flex"><a class="flex-shrink-0" href="#"><img class="img-fluid rounded-circle" src="img/avatar-5.jpg" alt="person" width="50"></a>
                            <div class="ms-3">
                              <h5>Aria Smith</h5>
                              <p class="mb-0 text-xs text-gray-600 lh-1">Posted a new blog</p><small class="text-gray-600 fw-light">Today 5:60 pm - 12.06.2014</small>
                            </div>
                          </div>
                          <div class="text-right"><small class="text-gray-500">5min ago</small></div>
                        </div>
                      </div>
                       Item
                      <div class="p-3 border-bottom border-gray-200">
                        <div class="d-flex justify-content-between">
                          <div class="d-flex"><a class="flex-shrink-0" href="#"><img class="img-fluid rounded-circle" src="img/avatar-2.jpg" alt="person" width="50"></a>
                            <div class="ms-3">
                              <h5>Frank Williams</h5>
                              <p class="mb-0 text-xs text-gray-600 lh-1">Posted a new blog</p><small class="text-gray-600 fw-light">Today 5:60 pm - 12.06.2014</small>
                              <div class="d-flex"><a class="btn btn-sm btn-secondary py-1 m-1" href="#"><i class="fas fa-thumbs-up me-1"></i>Like</a><a class="btn btn-sm btn-secondary py-1 m-1" href="#"><i class="fas fa-heart me-1"> </i>Love  </a></div>
                            </div>
                          </div>
                          <div class="text-right"><small class="text-gray-500">5min ago</small></div>
                        </div>
                      </div>
                       Item
                      <div class="p-3">
                        <div class="d-flex justify-content-between">
                          <div class="d-flex"><a class="flex-shrink-0" href="#"><img class="img-fluid rounded-circle" src="img/avatar-3.jpg" alt="person" width="50"></a>
                            <div class="ms-3">
                              <h5>Ashley Wood</h5>
                              <p class="mb-0 text-xs text-gray-600 lh-1">Posted a new blog</p><small class="text-gray-600 fw-light">Today 5:60 pm - 12.06.2014</small>
                            </div>
                          </div>
                          <div class="text-right"><small class="text-gray-500">5min ago</small></div>
                        </div>
                        <div class="mt-3 ms-5 ps-3">
                          <div class="bg-light p-3 shadow-sm"><small class="text-gray-600">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s. Over the years.</small></div>
                          <div class="text-end mt-1"><a class="btn btn-sm btn-secondary py-1" href="#"><i class="fas fa-thumbs-up me-1"></i>Like</a></div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                 Recent Activities 
                <div class="col-lg-4">
                  <div class="card mb-0">
                    <div class="card-header position-relative">
                      <div class="card-close">
                        <div class="dropdown">
                          <button class="dropdown-toggle text-sm" type="button" id="closeCard1" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-ellipsis-v"></i></button>
                          <div class="dropdown-menu dropdown-menu-end shadow-sm" aria-labelledby="closeCard1"><a class="dropdown-item py-1 px-3 remove" href="#"> <i class="fas fa-times"></i>Close</a><a class="dropdown-item py-1 px-3 edit" href="#"> <i class="fas fa-cog"></i>Edit</a></div>
                        </div>
                      </div>
                      <h3 class="h4 mb-0">Recent Activities</h3>
                    </div>
                    <div class="card-body p-0">
                      <div class="row g-0 border-bottom border-gray-200">
                        <div class="col-sm-4 col-3 text-end">
                          <ul class="list-inline mb-0">
                            <li>
                              <div class="d-inline-block p-2 bg-light"><i class="far fa-clock fa-fw"></i></div>
                            </li>
                            <li class="me-2"><span class="small text-gray-500">6:00 am</span></li>
                            <li class="me-2"><span class="small text-info lh-1 d-block">6 hours ago</span></li>
                          </ul>
                        </div>
                        <div class="col-sm-8 col-9 border-start border-gray-200 p-3">
                          <h5 class="fw-normal">Meeting</h5>
                          <p class="small mb-0 text-gray-600">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud.</p>
                        </div>
                      </div>
                      <div class="row g-0 border-bottom border-gray-200">
                        <div class="col-sm-4 col-3 text-end">
                          <ul class="list-inline mb-0">
                            <li>
                              <div class="d-inline-block p-2 bg-light"><i class="far fa-clock fa-fw"></i></div>
                            </li>
                            <li class="me-2"><span class="small text-gray-500">6:00 am</span></li>
                            <li class="me-2"><span class="small text-info lh-1 d-block">6 hours ago</span></li>
                          </ul>
                        </div>
                        <div class="col-sm-8 col-9 border-start border-gray-200 p-3">
                          <h5 class="fw-normal">Meeting</h5>
                          <p class="small mb-0 text-gray-600">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud.</p>
                        </div>
                      </div>
                      <div class="row g-0">
                        <div class="col-sm-4 col-3 text-end">
                          <ul class="list-inline mb-0">
                            <li>
                              <div class="d-inline-block p-2 bg-light"><i class="far fa-clock fa-fw"></i></div>
                            </li>
                            <li class="me-2"><span class="small text-gray-500">6:00 am</span></li>
                            <li class="me-2"><span class="small text-info lh-1 d-block">6 hours ago</span></li>
                          </ul>
                        </div>
                        <div class="col-sm-8 col-9 border-start border-gray-200 p-3">
                          <h5 class="fw-normal">Meeting</h5>
                          <p class="small mb-0 text-gray-600">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud.</p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </section>-->
          <!-- Page Footer-->
          <footer class="position-absolute bottom-0 bg-darkBlue text-white text-center py-3 w-100 text-xs" id="footer">
            <div class="container-fluid">
              <div class="row gy-2">
                <div class="col-sm-6 text-sm-start">
                  <p class="mb-0">Your company &copy; 2017-2021</p>
                </div>
                <div class="col-sm-6 text-sm-end">
                  <p class="mb-0">Design by <a href="https://bootstrapious.com/p/admin-template" class="text-white text-decoration-none">Bootstrapious</a></p>
                  <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
                </div>
              </div>
            </div>
          </footer>
        </div>
      </div>
    </div>
    <!-- JavaScript files-->
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="vendor/chart.js/Chart.min.js"></script>
    <script src="vendor/just-validate/js/just-validate.min.js"></script>
    <script src="vendor/choices.js/public/assets/scripts/choices.min.js"></script>
    <script src="js/charts-home.js"></script>
    <!-- Main File-->
    <script src="js/front.js"></script>
    <script>
      // ------------------------------------------------------- //
      //   Inject SVG Sprite - 
      //   see more here 
      //   https://css-tricks.com/ajaxing-svg-sprite/
      // ------------------------------------------------------ //
      function injectSvgSprite(path) {
      
          var ajax = new XMLHttpRequest();
          ajax.open("GET", path, true);
          ajax.send();
          ajax.onload = function(e) {
          var div = document.createElement("div");
          div.className = 'd-none';
          div.innerHTML = ajax.responseText;
          document.body.insertBefore(div, document.body.childNodes[0]);
          }
      }
      // this is set to BootstrapTemple website as you cannot 
      // inject local SVG sprite (using only 'icons/orion-svg-sprite.svg' path)
      // while using file:// protocol
      // pls don't forget to change to your domain :)
      injectSvgSprite('https://bootstraptemple.com/files/icons/orion-svg-sprite.svg'); 
      
      
    </script>
    <!-- FontAwesome CSS - loading as last, so it doesn't block rendering-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
  </body>
</html>
